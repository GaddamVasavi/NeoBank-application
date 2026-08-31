package com.neobank.regulatory;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class LiquidityCoverageReturnDto {
    private UUID id; private UUID userId; private String authorityRef; private String submissionStatus; private BigDecimal reportedAmount; private String reportingCurrency; private String regulatoryNotes; private boolean filed; private Instant filedAt;
}
