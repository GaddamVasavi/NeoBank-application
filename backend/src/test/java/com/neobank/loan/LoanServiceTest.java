package com.neobank.loan;
import com.neobank.account.AccountRepository; import com.neobank.audit.AuditService; import com.neobank.transaction.TransactionRepository; import com.neobank.user.UserRepository;
import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {
    @InjectMocks private LoanServiceImpl loanService;
    @Test void testCalculateEmi() {
        BigDecimal emi = loanService.calculateEmi(new BigDecimal("10000"), new BigDecimal("10"), 12);
        assertNotNull(emi);
        assertTrue(emi.compareTo(BigDecimal.ZERO) > 0);
    }
}
