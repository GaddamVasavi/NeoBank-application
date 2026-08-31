package com.neobank.clearing;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Daily end-of-day cash variation margin mark-to-market call */
@Entity @Table(name = "variationmarginsettlementfiles") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class VariationMarginSettlementFile extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "institutional_ref", nullable = false, unique = true, length = 64) private String institutionalRef;
    @Column(name = "execution_status", nullable = false, length = 30) @Builder.Default private String executionStatus = "ACTIVE";
    @Column(name = "nominal_valuation", precision = 18, scale = 4) @Builder.Default private BigDecimal nominalValuation = BigDecimal.ZERO;
    @Column(name = "base_currency", length = 10) @Builder.Default private String baseCurrency = "USD";
    @Column(name = "regulatory_dossier", columnDefinition = "TEXT") private String regulatoryDossier;
    @Column(name = "is_compliant", nullable = false) @Builder.Default private boolean compliant = true;
    @Column(name = "finalized_at") @Builder.Default private Instant finalizedAt = Instant.now();
}
