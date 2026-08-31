package com.neobank.digitalvault;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Shamir secret sharing threshold MPC private key shard */
@Entity @Table(name = "multipartycomputationshares") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class MultiPartyComputationShare extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "protocol_reference", nullable = false, unique = true, length = 64) private String protocolReference;
    @Column(name = "operational_state", nullable = false, length = 30) @Builder.Default private String operationalState = "ACTIVE";
    @Column(name = "notional_metric", precision = 18, scale = 4) @Builder.Default private BigDecimal notionalMetric = BigDecimal.ZERO;
    @Column(name = "iso_currency", length = 10) @Builder.Default private String isoCurrency = "USD";
    @Column(name = "narrative_summary", columnDefinition = "TEXT") private String narrativeSummary;
    @Column(name = "is_active_record", nullable = false) @Builder.Default private boolean activeRecord = true;
    @Column(name = "timestamp_executed") @Builder.Default private Instant timestampExecuted = Instant.now();
}
