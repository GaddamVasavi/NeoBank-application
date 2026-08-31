package com.neobank.loan;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal;
@Entity @Table(name = "loan_products") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LoanProduct extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true, length = 100) private String name;
    @Column(name = "loan_type", nullable = false, length = 40) private String loanType;
    @Column(name = "min_amount", precision = 15, scale = 2) private BigDecimal minAmount;
    @Column(name = "max_amount", precision = 15, scale = 2) private BigDecimal maxAmount;
    @Column(name = "interest_rate", precision = 5, scale = 2) private BigDecimal interestRate;
    @Column(name = "min_tenure_months") private int minTenureMonths;
    @Column(name = "max_tenure_months") private int maxTenureMonths;
    @Column(name = "is_active") @Builder.Default private boolean active = true;
}
