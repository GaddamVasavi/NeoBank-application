package com.neobank.loan;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CollateralEvaluationDto {
    private UUID id; private UUID userId; private String codeReference; private String status; private BigDecimal scoreValue; private String metadataPayload; private Instant verifiedAt;
}
