package com.neobank.fxrates;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** ECB Euro foreign exchange reference rates daily fixing */
@Entity @Table(name = "centralbankfixinghistorys") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CentralBankFixingHistory extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "registry_key", nullable = false, unique = true, length = 64) private String registryKey;
    @Column(name = "delivery_status", nullable = false, length = 30) @Builder.Default private String deliveryStatus = "ACTIVE";
    @Column(name = "numeric_reading", precision = 18, scale = 4) @Builder.Default private BigDecimal numericReading = BigDecimal.ZERO;
    @Column(name = "currency_symbol", length = 10) @Builder.Default private String currencySymbol = "USD";
    @Column(name = "log_payload", columnDefinition = "TEXT") private String logPayload;
    @Column(name = "is_active_status", nullable = false) @Builder.Default private boolean activeStatus = true;
    @Column(name = "timestamp_logged") @Builder.Default private Instant timestampLogged = Instant.now();
}
