package com.neobank.loan;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class LoanAmortizationEntryDto {
    private UUID id; private UUID userId; private String recordKey; private String status; private BigDecimal metricValue; private String description; private String payloadData; private boolean valid; private Instant timestampRecorded;
}
