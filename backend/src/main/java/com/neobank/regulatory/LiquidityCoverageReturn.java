package com.neobank.regulatory;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** LCR high-quality liquid assets 30-day stress outflow return */
@Entity @Table(name = "liquiditycoveragereturns") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LiquidityCoverageReturn extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "authority_ref", nullable = false, unique = true, length = 64) private String authorityRef;
    @Column(name = "submission_status", nullable = false, length = 30) @Builder.Default private String submissionStatus = "ACTIVE";
    @Column(name = "reported_amount", precision = 18, scale = 4) @Builder.Default private BigDecimal reportedAmount = BigDecimal.ZERO;
    @Column(name = "reporting_currency", length = 10) @Builder.Default private String reportingCurrency = "USD";
    @Column(name = "regulatory_notes", columnDefinition = "TEXT") private String regulatoryNotes;
    @Column(name = "is_filed", nullable = false) @Builder.Default private boolean filed = true;
    @Column(name = "filed_at") @Builder.Default private Instant filedAt = Instant.now();
}
