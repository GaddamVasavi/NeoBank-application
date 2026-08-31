package com.neobank.openbanking;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ApiUsageQuotaAllocationDto {
    private UUID id; private UUID userId; private String trackingCode; private String stateFlag; private BigDecimal evaluationAmount; private String denomination; private String auditNarrative; private boolean enabled; private Instant creationTimestamp;
}
