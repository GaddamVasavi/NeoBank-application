package com.neobank.bonds;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class InflationIndexedBondAssetDto {
    private UUID id; private UUID userId; private String clearingKey; private String auditStatus; private BigDecimal principalValuation; private String baseIsoCode; private String executiveMemo; private boolean reconciled; private Instant reconciledAt;
}
