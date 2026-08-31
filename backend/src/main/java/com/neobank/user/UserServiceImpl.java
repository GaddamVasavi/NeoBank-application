package com.neobank.user;

import com.neobank.audit.AuditAction;
import com.neobank.audit.AuditService;
import com.neobank.audit.AuditSeverity;
import com.neobank.common.BadRequestException;
import com.neobank.common.ResourceNotFoundException;
import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserPreferenceRepository userPreferenceRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuditService auditService;

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(UUID userId) {
        User user = userRepository.findByIdWithRoles(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return mapToDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getCurrentUser() {
        UUID currentUserId = SecurityUtils.getCurrentUserId();
        if (currentUserId == null) {
            throw new ResourceNotFoundException("No authenticated user in context");
        }
        return getUserById(currentUserId);
    }

    @Override
    @Transactional
    public void changePassword(UUID userId, ChangePasswordRequest request) {
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new BadRequestException("New passwords do not match");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPasswordHash())) {
            throw new BadRequestException("Current password does not match");
        }
        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        user.setLastPasswordChangeAt(Instant.now());
        userRepository.save(user);
        auditService.log(userId, user.getUsername(), AuditAction.PASSWORD_CHANGE, "User", userId.toString(),
                "SUCCESS", "Password changed", null, null, AuditSeverity.INFO);
    }

    @Override
    @Transactional(readOnly = true)
    public UserPreferencesDto getUserPreferences(UUID userId) {
        UserPreference pref = userPreferenceRepository.findByUserId(userId)
                .orElseGet(() -> UserPreference.builder().build());
        return UserPreferencesDto.builder()
                .theme(pref.getTheme())
                .currency(pref.getCurrency())
                .language(pref.getLanguage())
                .emailNotifications(pref.isEmailNotifications())
                .smsNotifications(pref.isSmsNotifications())
                .pushNotifications(pref.isPushNotifications())
                .marketingEmails(pref.isMarketingEmails())
                .twoFactorOnLogin(pref.isTwoFactorOnLogin())
                .twoFactorOnTransfer(pref.isTwoFactorOnTransfer())
                .build();
    }

    @Override
    @Transactional
    public UserPreferencesDto updateUserPreferences(UUID userId, UserPreferencesDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        UserPreference pref = userPreferenceRepository.findByUserId(userId)
                .orElseGet(() -> UserPreference.builder().user(user).build());
        pref.setTheme(dto.getTheme() != null ? dto.getTheme() : "DARK");
        pref.setCurrency(dto.getCurrency() != null ? dto.getCurrency() : "USD");
        pref.setLanguage(dto.getLanguage() != null ? dto.getLanguage() : "en");
        pref.setEmailNotifications(dto.isEmailNotifications());
        pref.setSmsNotifications(dto.isSmsNotifications());
        pref.setPushNotifications(dto.isPushNotifications());
        pref.setMarketingEmails(dto.isMarketingEmails());
        pref.setTwoFactorOnLogin(dto.isTwoFactorOnLogin());
        pref.setTwoFactorOnTransfer(dto.isTwoFactorOnTransfer());
        userPreferenceRepository.save(pref);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressDto> getUserAddresses(UUID userId) {
        return addressRepository.findByUserId(userId).stream()
                .map(this::mapAddressToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AddressDto addAddress(UUID userId, AddressDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Address address = Address.builder()
                .user(user)
                .addressType(dto.getAddressType() != null ? dto.getAddressType() : AddressType.RESIDENTIAL)
                .streetLine1(dto.getStreetLine1())
                .streetLine2(dto.getStreetLine2())
                .city(dto.getCity())
                .stateProvince(dto.getStateProvince())
                .postalCode(dto.getPostalCode())
                .country(dto.getCountry() != null ? dto.getCountry() : "United States")
                .primary(dto.isPrimary())
                .build();
        return mapAddressToDto(addressRepository.save(address));
    }

    @Override
    @Transactional
    public void deleteAddress(UUID userId, UUID addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressId));
        if (!address.getUser().getId().equals(userId)) {
            throw new BadRequestException("Address does not belong to user");
        }
        addressRepository.delete(address);
    }

    private UserDto mapToDto(User user) {
        ProfileDto profileDto = null;
        if (user.getProfile() != null) {
            CustomerProfile p = user.getProfile();
            profileDto = ProfileDto.builder()
                    .id(p.getId())
                    .firstName(p.getFirstName())
                    .middleName(p.getMiddleName())
                    .lastName(p.getLastName())
                    .fullName(p.getFullName())
                    .dateOfBirth(p.getDateOfBirth())
                    .gender(p.getGender())
                    .nationality(p.getNationality())
                    .avatarUrl(p.getAvatarUrl())
                    .occupation(p.getOccupation())
                    .annualIncome(p.getAnnualIncome())
                    .kycStatus(p.getKycStatus())
                    .riskScore(p.getRiskScore())
                    .build();
        }
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .emailVerified(user.isEmailVerified())
                .phoneVerified(user.isPhoneVerified())
                .mfaEnabled(user.isMfaEnabled())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()))
                .profile(profileDto)
                .createdAt(user.getCreatedAt())
                .build();
    }

    private AddressDto mapAddressToDto(Address addr) {
        return AddressDto.builder()
                .id(addr.getId())
                .addressType(addr.getAddressType())
                .streetLine1(addr.getStreetLine1())
                .streetLine2(addr.getStreetLine2())
                .city(addr.getCity())
                .stateProvince(addr.getStateProvince())
                .postalCode(addr.getPostalCode())
                .country(addr.getCountry())
                .primary(addr.isPrimary())
                .build();
    }
}
