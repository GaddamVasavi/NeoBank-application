package com.neobank.transaction;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "exchange_rates") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class ExchangeRate extends BaseEntity {
    @Column(name = "source_currency", nullable = false, length = 10) private String sourceCurrency;
    @Column(name = "target_currency", nullable = false, length = 10) private String targetCurrency;
    @Column(name = "rate", nullable = false, precision = 12, scale = 6) private BigDecimal rate;
    @Column(name = "effective_at", nullable = false) @Builder.Default private Instant effectiveAt = Instant.now();
}
