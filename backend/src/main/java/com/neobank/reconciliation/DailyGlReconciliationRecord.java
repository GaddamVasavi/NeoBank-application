package com.neobank.reconciliation;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** End-of-day general ledger sub-ledger balance reconciliation */
@Entity @Table(name = "dailyglreconciliationrecords") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class DailyGlReconciliationRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "core_reference", nullable = false, unique = true, length = 64) private String coreReference;
    @Column(name = "processing_status", nullable = false, length = 30) @Builder.Default private String processingStatus = "ACTIVE";
    @Column(name = "certified_value", precision = 18, scale = 4) @Builder.Default private BigDecimal certifiedValue = BigDecimal.ZERO;
    @Column(name = "iso_currency", length = 10) @Builder.Default private String isoCurrency = "USD";
    @Column(name = "compliance_dossier", columnDefinition = "TEXT") private String complianceDossier;
    @Column(name = "is_audited", nullable = false) @Builder.Default private boolean audited = true;
    @Column(name = "certified_at") @Builder.Default private Instant certifiedAt = Instant.now();
}
