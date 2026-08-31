package com.neobank.account;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name = "interest_accruals") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class InterestAccrual extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id", nullable = false) private Account account;
    @Column(name = "accrual_date", nullable = false) private LocalDate accrualDate;
    @Column(name = "qualifying_balance", nullable = false, precision = 15, scale = 2) private BigDecimal qualifyingBalance;
    @Column(name = "interest_rate", nullable = false, precision = 5, scale = 2) private BigDecimal interestRate;
    @Column(name = "accrued_amount", nullable = false, precision = 15, scale = 2) private BigDecimal accruedAmount;
    @Column(name = "is_posted", nullable = false) @Builder.Default private boolean posted = false;
}
