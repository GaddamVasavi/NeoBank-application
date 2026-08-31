package com.neobank.custody;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AssetSafekeepingAuditTrailDto {
    private UUID id; private UUID userId; private String settlementRef; private String lifecycleStatus; private BigDecimal settlementAmount; private String settlementCurrency; private String complianceMemo; private boolean cleared; private Instant settledAt;
}
