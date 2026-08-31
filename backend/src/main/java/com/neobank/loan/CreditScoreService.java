package com.neobank.loan;
import java.math.BigDecimal; import java.util.UUID;
public interface CreditScoreService {
    CreditAssessment evaluateCustomerCredit(UUID userId, BigDecimal annualIncome);
}
