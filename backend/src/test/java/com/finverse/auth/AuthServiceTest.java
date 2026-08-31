package com.finverse.auth;
import com.finverse.users.User; import com.finverse.users.UserRepository;
import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith; import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    private User testUser;
    @BeforeEach void setUp() {
        testUser = User.builder().email("sarah@finverse.io").passwordHash("encoded_pw").firstName("Sarah").lastName("Jenkins").role("CUSTOMER").active(true).build();
        testUser.setId(UUID.randomUUID()); testUser.setTenantId(UUID.randomUUID());
    }
    @Test void testUserLookupByEmail() {
        when(userRepository.findByEmail("sarah@finverse.io")).thenReturn(Optional.of(testUser));
        Optional<User> found = userRepository.findByEmail("sarah@finverse.io");
        assertTrue(found.isPresent());
        assertEquals("Sarah", found.get().getFirstName());
    }
    @Test void testUserCreation() {
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        User saved = userRepository.save(testUser);
        assertNotNull(saved.getId());
        assertEquals("sarah@finverse.io", saved.getEmail());
    }
}
