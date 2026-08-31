package com.neobank.user;
import com.neobank.audit.AuditService; import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock private UserRepository userRepository;
    @Mock private UserPreferenceRepository userPreferenceRepository;
    @Mock private AddressRepository addressRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private AuditService auditService;
    @InjectMocks private UserServiceImpl userService;
    @Test void testGetUserById() {
        UUID userId = UUID.randomUUID();
        User user = User.builder().id(userId).username("alex").email("alex@neobank.com").status(UserStatus.ACTIVE).build();
        when(userRepository.findByIdWithRoles(userId)).thenReturn(Optional.of(user));
        UserDto dto = userService.getUserById(userId);
        assertNotNull(dto);
        assertEquals("alex", dto.getUsername());
    }
}
