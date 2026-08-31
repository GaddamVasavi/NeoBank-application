package com.neobank.loan;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "credit_assessments") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CreditAssessment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "credit_score", nullable = false) private int creditScore;
    @Column(name = "debt_to_income_ratio", precision = 5, scale = 2) private BigDecimal debtToIncomeRatio;
    @Column(name = "max_eligible_limit", precision = 15, scale = 2) private BigDecimal maxEligibleLimit;
    @Column(name = "risk_tier", length = 20) @Builder.Default private String riskTier = "LOW";
    @Column(name = "evaluated_at", nullable = false) @Builder.Default private Instant evaluatedAt = Instant.now();
}
