package com.neobank.auth;
import com.neobank.audit.AuditService; import com.neobank.security.JwtTokenProvider; import com.neobank.user.*;
import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager; import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock private UserRepository userRepository;
    @Mock private RoleRepository roleRepository;
    @Mock private CustomerProfileRepository profileRepository;
    @Mock private UserPreferenceRepository userPreferenceRepository;
    @Mock private RefreshTokenRepository refreshTokenRepository;
    @Mock private PasswordResetTokenRepository passwordResetTokenRepository;
    @Mock private OtpRecordRepository otpRecordRepository;
    @Mock private UserDeviceRepository userDeviceRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private JwtTokenProvider tokenProvider;
    @Mock private AuthenticationManager authenticationManager;
    @Mock private AuditService auditService;
    @InjectMocks private AuthServiceImpl authService;
    private User sampleUser;
    private Role customerRole;
    @BeforeEach void setUp() {
        customerRole = Role.builder().id(1L).name("ROLE_CUSTOMER").build();
        sampleUser = User.builder().id(UUID.randomUUID()).username("testuser").email("test@neobank.com").passwordHash("hash").status(UserStatus.ACTIVE).build();
    }
    @Test void testRegisterSuccess() {
        RegisterRequest req = new RegisterRequest();
        req.setUsername("newuser");
        req.setEmail("new@neobank.com");
        req.setPassword("Password123!");
        req.setFirstName("John");
        req.setLastName("Doe");
        when(userRepository.existsByUsername("newuser")).thenReturn(false);
        when(userRepository.existsByEmail("new@neobank.com")).thenReturn(false);
        when(roleRepository.findByName("ROLE_CUSTOMER")).thenReturn(Optional.of(customerRole));
        when(passwordEncoder.encode(any())).thenReturn("hash");
        when(userRepository.save(any(User.class))).thenReturn(sampleUser);
        when(tokenProvider.generateAccessToken(any(), any(), any(), any())).thenReturn("mockJwt");
        when(tokenProvider.getExpirationDurationMs()).thenReturn(86400000L);
        AuthResponse resp = authService.register(req);
        assertNotNull(resp);
        assertEquals("mockJwt", resp.getAccessToken());
    }
}
