package com.finverse.accounts;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
public class AccountServiceTest {
    @Test void testAccountBalanceMath() {
        BigDecimal initial = new BigDecimal("10000.00");
        BigDecimal deposit = new BigDecimal("2500.50");
        BigDecimal withdrawal = new BigDecimal("1200.00");
        BigDecimal finalBal = initial.add(deposit).subtract(withdrawal);
        assertEquals(new BigDecimal("11300.50"), finalBal);
    }
}
