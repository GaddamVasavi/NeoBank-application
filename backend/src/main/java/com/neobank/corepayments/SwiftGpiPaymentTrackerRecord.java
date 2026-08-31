package com.neobank.corepayments;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** SWIFT Global Payments Innovation (gpi) end-to-end payment SLA */
@Entity @Table(name = "swiftgpipaymenttrackerrecords") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SwiftGpiPaymentTrackerRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "clearing_key", nullable = false, unique = true, length = 64) private String clearingKey;
    @Column(name = "audit_status", nullable = false, length = 30) @Builder.Default private String auditStatus = "ACTIVE";
    @Column(name = "principal_valuation", precision = 18, scale = 4) @Builder.Default private BigDecimal principalValuation = BigDecimal.ZERO;
    @Column(name = "base_iso_code", length = 10) @Builder.Default private String baseIsoCode = "USD";
    @Column(name = "executive_memo", columnDefinition = "TEXT") private String executiveMemo;
    @Column(name = "is_reconciled", nullable = false) @Builder.Default private boolean reconciled = true;
    @Column(name = "reconciled_at") @Builder.Default private Instant reconciledAt = Instant.now();
}
