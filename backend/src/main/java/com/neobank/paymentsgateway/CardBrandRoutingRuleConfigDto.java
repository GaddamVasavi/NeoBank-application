package com.neobank.paymentsgateway;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CardBrandRoutingRuleConfigDto {
    private UUID id; private UUID userId; private String systemIdentifier; private String validationState; private BigDecimal marketValuation; private String currencyCode; private String narrativeNotes; private boolean verified; private Instant recordedTimestamp;
}
