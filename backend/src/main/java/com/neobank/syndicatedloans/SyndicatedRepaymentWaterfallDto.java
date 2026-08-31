package com.neobank.syndicatedloans;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SyndicatedRepaymentWaterfallDto {
    private UUID id; private UUID userId; private String protocolReference; private String operationalState; private BigDecimal notionalMetric; private String isoCurrency; private String narrativeSummary; private boolean activeRecord; private Instant timestampExecuted;
}
