package com.neobank.loan;
import com.neobank.account.Account; import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "loans") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Loan extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id", nullable = false) private Account account;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "product_id", nullable = false) private LoanProduct product;
    @Column(name = "loan_reference", nullable = false, unique = true, length = 36) private String loanReference;
    @Column(name = "loan_type", nullable = false, length = 40) private String loanType;
    @Column(name = "principal_amount", nullable = false, precision = 15, scale = 2) private BigDecimal principalAmount;
    @Column(name = "total_amount_payable", nullable = false, precision = 15, scale = 2) private BigDecimal totalAmountPayable;
    @Column(name = "outstanding_balance", nullable = false, precision = 15, scale = 2) private BigDecimal outstandingBalance;
    @Column(name = "interest_rate", precision = 5, scale = 2) private BigDecimal interestRate;
    @Column(name = "tenure_months", nullable = false) private int tenureMonths;
    @Column(name = "monthly_installment", precision = 15, scale = 2) private BigDecimal monthlyInstallment;
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "ACTIVE";
    @Column(name = "disbursed_at") private Instant disbursedAt;
}
