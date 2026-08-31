package com.neobank.treasuryoperations;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Standing central bank monetary policy open market auction tender */
@Entity @Table(name = "centralbankauctiontenders") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CentralBankAuctionTender extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "clearing_identifier", nullable = false, unique = true, length = 64) private String clearingIdentifier;
    @Column(name = "settlement_status", nullable = false, length = 30) @Builder.Default private String settlementStatus = "ACTIVE";
    @Column(name = "contract_valuation", precision = 18, scale = 4) @Builder.Default private BigDecimal contractValuation = BigDecimal.ZERO;
    @Column(name = "settlement_currency", length = 10) @Builder.Default private String settlementCurrency = "USD";
    @Column(name = "clearing_memo", columnDefinition = "TEXT") private String clearingMemo;
    @Column(name = "is_reconciled", nullable = false) @Builder.Default private boolean reconciled = true;
    @Column(name = "executed_timestamp") @Builder.Default private Instant executedTimestamp = Instant.now();
}
