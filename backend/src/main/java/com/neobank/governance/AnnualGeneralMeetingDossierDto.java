package com.neobank.governance;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AnnualGeneralMeetingDossierDto {
    private UUID id; private UUID userId; private String institutionalRef; private String executionStatus; private BigDecimal nominalValuation; private String baseCurrency; private String regulatoryDossier; private boolean compliant; private Instant finalizedAt;
}
