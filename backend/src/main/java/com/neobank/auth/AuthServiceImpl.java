package com.neobank.auth;

import com.neobank.audit.AuditAction;
import com.neobank.audit.AuditService;
import com.neobank.audit.AuditSeverity;
import com.neobank.common.*;
import com.neobank.security.JwtTokenProvider;
import com.neobank.security.UserPrincipal;
import com.neobank.user.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomerProfileRepository profileRepository;
    private final UserPreferenceRepository userPreferenceRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final OtpRecordRepository otpRecordRepository;
    private final UserDeviceRepository userDeviceRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final AuditService auditService;

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ConflictException("Username is already taken");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException("Email address is already in use");
        }

        Role customerRole = roleRepository.findByName("ROLE_CUSTOMER")
                .orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_CUSTOMER").description("Customer").build()));

        User user = User.builder()
                .username(request.getUsername().toLowerCase().trim())
                .email(request.getEmail().toLowerCase().trim())
                .phoneNumber(request.getPhoneNumber())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .status(UserStatus.ACTIVE)
                .emailVerified(false)
                .roles(new HashSet<>(Collections.singletonList(customerRole)))
                .build();

        User savedUser = userRepository.save(user);

        CustomerProfile profile = CustomerProfile.builder()
                .user(savedUser)
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .occupation(request.getOccupation())
                .annualIncome(request.getAnnualIncome())
                .kycStatus("UNVERIFIED")
                .riskScore(10)
                .build();
        profileRepository.save(profile);

        UserPreference preferences = UserPreference.builder()
                .user(savedUser)
                .theme("DARK")
                .currency("USD")
                .language("en")
                .build();
        userPreferenceRepository.save(preferences);

        auditService.log(savedUser.getId(), savedUser.getUsername(), AuditAction.REGISTER, "User",
                savedUser.getId().toString(), "SUCCESS", "Registration completed", null, null, AuditSeverity.INFO);

        List<String> roleNames = Collections.singletonList("ROLE_CUSTOMER");
        String accessToken = tokenProvider.generateAccessToken(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), roleNames);
        String refreshToken = generateAndSaveRefreshToken(savedUser, null);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresInMs(tokenProvider.getExpirationDurationMs())
                .roles(new HashSet<>(roleNames))
                .user(mapToUserDto(savedUser, profile, preferences))
                .build();
    }

    @Override
    @Transactional
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        if (user.getLockoutUntil() != null && user.getLockoutUntil().isAfter(Instant.now())) {
            throw new AccountLockedException("Account is temporarily locked. Try again later.");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword())
            );

            user.setFailedLoginAttempts(0);
            user.setLockoutUntil(null);
            user.setLastLoginAt(Instant.now());
            userRepository.save(user);

            if (user.isMfaEnabled()) {
                String mfaSessionToken = tokenProvider.generateMfaSessionToken(user.getId(), user.getEmail());
                sendOtp(user.getEmail(), OtpType.LOGIN_MFA);
                return AuthResponse.builder()
                        .mfaRequired(true)
                        .mfaSessionToken(mfaSessionToken)
                        .build();
            }

            UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
            String accessToken = tokenProvider.generateAccessToken(authentication);
            String refreshToken = generateAndSaveRefreshToken(user, request.getDeviceInfo());

            Set<String> roles = principal.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toSet());

            auditService.log(user.getId(), user.getUsername(), AuditAction.LOGIN, "User", user.getId().toString(),
                    "SUCCESS", "User login", null, null, AuditSeverity.INFO);

            return AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .expiresInMs(tokenProvider.getExpirationDurationMs())
                    .roles(roles)
                    .user(mapToUserDto(user, user.getProfile(), user.getPreferences()))
                    .build();
        } catch (BadCredentialsException ex) {
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            if (user.getFailedLoginAttempts() >= 5) {
                user.setLockoutUntil(Instant.now().plus(30, ChronoUnit.MINUTES));
            }
            userRepository.save(user);
            throw ex;
        }
    }

    @Override
    @Transactional
    public AuthResponse verifyMfa(MfaVerifyRequest request) {
        if (!tokenProvider.validateToken(request.getMfaSessionToken())) {
            throw new InvalidTokenException("Invalid or expired MFA session token");
        }
        UUID userId = tokenProvider.getUserIdFromToken(request.getMfaSessionToken());
        User user = userRepository.findByIdWithRoles(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        OtpVerifyRequest otpReq = new OtpVerifyRequest();
        otpReq.setContactTarget(user.getEmail());
        otpReq.setOtpCode(request.getCode());
        otpReq.setOtpType(OtpType.LOGIN_MFA);

        if (!verifyOtp(otpReq)) {
            throw new BadRequestException("Invalid MFA verification code");
        }

        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        String accessToken = tokenProvider.generateAccessToken(user.getId(), user.getUsername(), user.getEmail(), roles);
        String refreshToken = generateAndSaveRefreshToken(user, request.getDeviceInfo());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresInMs(tokenProvider.getExpirationDurationMs())
                .roles(new HashSet<>(roles))
                .user(mapToUserDto(user, user.getProfile(), user.getPreferences()))
                .build();
    }

    @Override
    @Transactional
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        String tokenHash = CryptoUtils.sha256Hex(request.getRefreshToken());
        RefreshToken storedToken = refreshTokenRepository.findByTokenHash(tokenHash)
                .orElseThrow(() -> new InvalidTokenException("Invalid refresh token"));

        if (!storedToken.isValid()) {
            throw new InvalidTokenException("Refresh token is expired or revoked");
        }

        User user = storedToken.getUser();
        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        String newAccessToken = tokenProvider.generateAccessToken(user.getId(), user.getUsername(), user.getEmail(), roles);
        storedToken.setRevoked(true);
        storedToken.setRevokedAt(Instant.now());
        refreshTokenRepository.save(storedToken);

        String newRefreshToken = generateAndSaveRefreshToken(user, null);
        return AuthResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .expiresInMs(tokenProvider.getExpirationDurationMs())
                .roles(new HashSet<>(roles))
                .build();
    }

    @Override
    @Transactional
    public void logout(UUID userId, String refreshToken) {
        if (refreshToken != null) {
            String tokenHash = CryptoUtils.sha256Hex(refreshToken);
            refreshTokenRepository.findByTokenHash(tokenHash).ifPresent(rt -> {
                rt.setRevoked(true);
                rt.setRevokedAt(Instant.now());
                refreshTokenRepository.save(rt);
            });
        }
    }

    @Override
    @Transactional
    public void requestPasswordReset(PasswordResetRequest request) {
        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            String rawToken = CryptoUtils.generateSecureToken(32);
            String tokenHash = CryptoUtils.sha256Hex(rawToken);
            PasswordResetToken resetToken = PasswordResetToken.builder()
                    .user(user)
                    .tokenHash(tokenHash)
                    .expiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                    .used(false)
                    .build();
            passwordResetTokenRepository.save(resetToken);
        });
    }

    @Override
    @Transactional
    public void confirmPasswordReset(PasswordResetConfirmRequest request) {
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new BadRequestException("Passwords do not match");
        }
        String tokenHash = CryptoUtils.sha256Hex(request.getToken());
        PasswordResetToken resetToken = passwordResetTokenRepository.findByTokenHash(tokenHash)
                .orElseThrow(() -> new InvalidTokenException("Invalid reset token"));
        if (!resetToken.isValid()) {
            throw new InvalidTokenException("Reset token is expired or used");
        }
        User user = resetToken.getUser();
        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        user.setLastPasswordChangeAt(Instant.now());
        userRepository.save(user);
        resetToken.setUsed(true);
        passwordResetTokenRepository.save(resetToken);
        refreshTokenRepository.revokeAllUserTokens(user.getId());
    }

    @Override
    @Transactional
    public void sendOtp(String contactTarget, OtpType type) {
        String code = CryptoUtils.generateOtp(6);
        OtpRecord record = OtpRecord.builder()
                .contactTarget(contactTarget)
                .otpCode(code)
                .otpType(type)
                .expiresAt(Instant.now().plus(10, ChronoUnit.MINUTES))
                .verified(false)
                .attemptsCount(0)
                .build();
        otpRecordRepository.save(record);
    }

    @Override
    @Transactional
    public boolean verifyOtp(OtpVerifyRequest request) {
        OtpRecord record = otpRecordRepository.findTopByContactTargetAndOtpTypeOrderByCreatedAtDesc(
                request.getContactTarget(), request.getOtpType()).orElse(null);
        if (record == null || record.isVerified() || record.isExpired()) return false;
        record.setAttemptsCount(record.getAttemptsCount() + 1);
        if (record.getOtpCode().equals(request.getOtpCode().trim())) {
            record.setVerified(true);
            otpRecordRepository.save(record);
            return true;
        }
        otpRecordRepository.save(record);
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeviceResponse> getUserDevices(UUID userId) {
        return userDeviceRepository.findByUserIdOrderByLastActiveAtDesc(userId).stream()
                .map(d -> DeviceResponse.builder()
                        .id(d.getId())
                        .deviceFingerprint(d.getDeviceFingerprint())
                        .deviceName(d.getDeviceName())
                        .deviceType(d.getDeviceType())
                        .operatingSystem(d.getOperatingSystem())
                        .browser(d.getBrowser())
                        .ipAddress(d.getIpAddress())
                        .trusted(d.isTrusted())
                        .lastActiveAt(d.getLastActiveAt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void trustDevice(UUID userId, UUID deviceId) {
        UserDevice device = userDeviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device", "id", deviceId));
        if (!device.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        device.setTrusted(true);
        userDeviceRepository.save(device);
    }

    @Override
    @Transactional
    public void removeDevice(UUID userId, UUID deviceId) {
        UserDevice device = userDeviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device", "id", deviceId));
        if (!device.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        userDeviceRepository.delete(device);
    }

    private String generateAndSaveRefreshToken(User user, DeviceInfo deviceInfo) {
        String rawToken = CryptoUtils.generateSecureToken(48);
        String tokenHash = CryptoUtils.sha256Hex(rawToken);
        RefreshToken token = RefreshToken.builder()
                .user(user)
                .tokenHash(tokenHash)
                .expiresAt(Instant.now().plus(7, ChronoUnit.DAYS))
                .revoked(false)
                .build();
        refreshTokenRepository.save(token);
        return rawToken;
    }

    private UserDto mapToUserDto(User user, CustomerProfile profile, UserPreference pref) {
        ProfileDto pDto = profile != null ? ProfileDto.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .middleName(profile.getMiddleName())
                .lastName(profile.getLastName())
                .fullName(profile.getFullName())
                .build() : null;
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .emailVerified(user.isEmailVerified())
                .mfaEnabled(user.isMfaEnabled())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()))
                .profile(pDto)
                .createdAt(user.getCreatedAt())
                .build();
    }
}
