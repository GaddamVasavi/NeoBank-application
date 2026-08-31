package com.neobank.securities;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Self-directed and managed brokerage client trading agreement */
@Entity @Table(name = "brokerageaccountmandates") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class BrokerageAccountMandate extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "system_identifier", nullable = false, unique = true, length = 64) private String systemIdentifier;
    @Column(name = "validation_state", nullable = false, length = 30) @Builder.Default private String validationState = "ACTIVE";
    @Column(name = "market_valuation", precision = 18, scale = 4) @Builder.Default private BigDecimal marketValuation = BigDecimal.ZERO;
    @Column(name = "currency_code", length = 10) @Builder.Default private String currencyCode = "USD";
    @Column(name = "narrative_notes", columnDefinition = "TEXT") private String narrativeNotes;
    @Column(name = "is_verified", nullable = false) @Builder.Default private boolean verified = true;
    @Column(name = "recorded_timestamp") @Builder.Default private Instant recordedTimestamp = Instant.now();
}
