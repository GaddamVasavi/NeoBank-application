package com.neobank.compliance;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AuditTrailExportArchiveDto {
    private UUID id; private UUID userId; private String identifierCode; private String status; private BigDecimal nominalAmount; private String currency; private String specificationNotes; private boolean active; private Instant executedAt;
}
