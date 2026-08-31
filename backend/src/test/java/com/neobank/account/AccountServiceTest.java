package com.neobank.account;
import com.neobank.audit.AuditService; import com.neobank.user.User; import com.neobank.user.UserRepository;
import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal; import java.util.List; import java.util.Optional; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @Mock private AccountRepository accountRepository;
    @Mock private UserRepository userRepository;
    @Mock private AuditService auditService;
    @InjectMocks private AccountServiceImpl accountService;
    @Test void testCreateAccount() {
        UUID userId = UUID.randomUUID();
        User user = User.builder().id(userId).username("alex").build();
        CreateAccountRequest req = new CreateAccountRequest();
        req.setAccountType(AccountType.SAVINGS);
        req.setInitialDeposit(new BigDecimal("500.00"));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(accountRepository.save(any())).thenAnswer(i -> i.getArgument(0));
        AccountDto dto = accountService.createAccount(userId, req);
        assertNotNull(dto);
        assertEquals(new BigDecimal("500.00"), dto.getBalance());
    }
}
