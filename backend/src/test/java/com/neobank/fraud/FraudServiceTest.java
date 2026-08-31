package com.neobank.fraud;
import com.neobank.audit.AuditService; import com.neobank.user.UserRepository;
import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class FraudServiceTest {
    @Mock private FraudCaseRepository caseRepository;
    @Mock private FraudRuleRepository ruleRepository;
    @Mock private UserRepository userRepository;
    @Mock private AuditService auditService;
    @InjectMocks private FraudServiceImpl fraudService;
    @Test void testEvaluateRiskLow() {
        int score = fraudService.evaluateTransactionRisk(UUID.randomUUID(), new BigDecimal("100.00"));
        assertEquals(5, score);
    }
    @Test void testEvaluateRiskHigh() {
        int score = fraudService.evaluateTransactionRisk(UUID.randomUUID(), new BigDecimal("15000.00"));
        assertTrue(score >= 70);
    }
}
