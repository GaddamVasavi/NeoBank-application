package com.neobank.treasuryoperations;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SovereignDebtYieldCurveDto {
    private UUID id; private UUID userId; private String clearingIdentifier; private String settlementStatus; private BigDecimal contractValuation; private String settlementCurrency; private String clearingMemo; private boolean reconciled; private Instant executedTimestamp;
}
