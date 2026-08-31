package com.neobank.fxrates;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class RealTimeFxRateStreamLogDto {
    private UUID id; private UUID userId; private String registryKey; private String deliveryStatus; private BigDecimal numericReading; private String currencySymbol; private String logPayload; private boolean activeStatus; private Instant timestampLogged;
}
