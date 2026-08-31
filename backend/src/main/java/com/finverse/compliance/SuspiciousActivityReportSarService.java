package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SuspiciousActivityReportSar
 */
public interface SuspiciousActivityReportSarService {

    List<SuspiciousActivityReportSarDto> getByTenant(UUID tenantId);

    List<SuspiciousActivityReportSarDto> getByUser(UUID userId);

    SuspiciousActivityReportSarDto create(SuspiciousActivityReportSarDto dto);

    SuspiciousActivityReportSarDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SuspiciousActivityReportSarDto> listAll();
}
