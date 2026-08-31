package com.neobank.loan;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
public interface LoanService {
    List<LoanProduct> getLoanProducts();
    List<Loan> getUserLoans(UUID userId);
    Loan applyForLoan(UUID userId, UUID accountId, UUID productId, BigDecimal principal, int tenureMonths);
    BigDecimal calculateEmi(BigDecimal principal, BigDecimal rate, int months);
}
