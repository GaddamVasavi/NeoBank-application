package com.neobank.settlementgateway;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Intraday interbank liquidity swap and repo facility usage log */
@Entity @Table(name = "interbankliquidityswaplogs") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class InterbankLiquiditySwapLog extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "gateway_reference", nullable = false, unique = true, length = 64) private String gatewayReference;
    @Column(name = "settlement_state", nullable = false, length = 30) @Builder.Default private String settlementState = "ACTIVE";
    @Column(name = "settled_valuation", precision = 18, scale = 4) @Builder.Default private BigDecimal settledValuation = BigDecimal.ZERO;
    @Column(name = "currency_iso", length = 10) @Builder.Default private String currencyIso = "USD";
    @Column(name = "audit_dossier", columnDefinition = "TEXT") private String auditDossier;
    @Column(name = "is_finalized", nullable = false) @Builder.Default private boolean finalized = true;
    @Column(name = "finalized_timestamp") @Builder.Default private Instant finalizedTimestamp = Instant.now();
}
