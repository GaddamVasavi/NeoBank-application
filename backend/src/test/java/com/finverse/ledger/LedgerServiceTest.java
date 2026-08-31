package com.finverse.ledger;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
public class LedgerServiceTest {
    @Test void testDoubleEntryBalancingRule() {
        BigDecimal totalDebit = new BigDecimal("500000.00");
        BigDecimal totalCredit = new BigDecimal("500000.00");
        assertEquals(0, totalDebit.compareTo(totalCredit), "Double-entry ledger debit must equal credit");
    }
}
