package com.neobank.trade;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** International customs declaration and trade compliance */
@Entity @Table(name = "customsexportclearances") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CustomsExportClearance extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "settlement_ref", nullable = false, unique = true, length = 64) private String settlementRef;
    @Column(name = "lifecycle_status", nullable = false, length = 30) @Builder.Default private String lifecycleStatus = "ACTIVE";
    @Column(name = "settlement_amount", precision = 18, scale = 4) @Builder.Default private BigDecimal settlementAmount = BigDecimal.ZERO;
    @Column(name = "settlement_currency", length = 10) @Builder.Default private String settlementCurrency = "USD";
    @Column(name = "compliance_memo", columnDefinition = "TEXT") private String complianceMemo;
    @Column(name = "is_cleared", nullable = false) @Builder.Default private boolean cleared = true;
    @Column(name = "settled_at") @Builder.Default private Instant settledAt = Instant.now();
}
