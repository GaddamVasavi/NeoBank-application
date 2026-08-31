package com.finverse.compliance;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Data Transfer Object for SuspiciousActivityReportSar
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousActivityReportSarDto {
    private UUID id;
    private UUID tenantId;
    private UUID userId;
    @NotNull @Size(min = 4, max = 64) private String systemReference;
    private String operationalStatus;
    private BigDecimal certifiedQuantum;
    private String isoCurrency;
    private String complianceMemo;
    private boolean auditedRecord;
    private Instant timestampLogged;
}
