package com.neobank.analyticsengine;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EconomicCapitalAllocationDto {
    private UUID id; private UUID userId; private String coreReference; private String processingStatus; private BigDecimal certifiedValue; private String isoCurrency; private String complianceDossier; private boolean audited; private Instant certifiedAt;
}
