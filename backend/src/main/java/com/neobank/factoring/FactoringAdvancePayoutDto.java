package com.neobank.factoring;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class FactoringAdvancePayoutDto {
    private UUID id; private UUID userId; private String dossierReference; private String operationalStatus; private BigDecimal financialMetric; private String currencyIso; private String operationalDetails; private boolean activeFlag; private Instant loggedAt;
}
