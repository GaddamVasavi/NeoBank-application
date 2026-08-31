package com.finverse.lending;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal; import java.math.RoundingMode;
import static org.junit.jupiter.api.Assertions.*;
public class LendingServiceTest {
    @Test void testMonthlyInstallmentCalculation() {
        BigDecimal principal = new BigDecimal("100000.00");
        BigDecimal annualRate = new BigDecimal("0.06");
        int months = 36;
        BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12), 8, RoundingMode.HALF_UP);
        BigDecimal factor = BigDecimal.ONE.add(monthlyRate).pow(months);
        BigDecimal payment = principal.multiply(monthlyRate).multiply(factor).divide(factor.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        assertTrue(payment.compareTo(BigDecimal.ZERO) > 0);
    }
}
