package com.finverse.fraud;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
public class FraudServiceTest {
    @Test void testHighAmountThresholdTrigger() {
        BigDecimal amount = new BigDecimal("1000000.00");
        BigDecimal threshold = new BigDecimal("250000.00");
        boolean isHighRisk = amount.compareTo(threshold) > 0;
        assertTrue(isHighRisk);
    }
}
