package com.neobank.settlementgateway;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ClearingHouseMarginPoolDto {
    private UUID id; private UUID userId; private String gatewayReference; private String settlementState; private BigDecimal settledValuation; private String currencyIso; private String auditDossier; private boolean finalized; private Instant finalizedTimestamp;
}
