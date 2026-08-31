package com.finverse.reporting;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RegulatoryCapitalAdequacyReport
 */
public interface RegulatoryCapitalAdequacyReportService {

    List<RegulatoryCapitalAdequacyReportDto> getByTenant(UUID tenantId);

    List<RegulatoryCapitalAdequacyReportDto> getByUser(UUID userId);

    RegulatoryCapitalAdequacyReportDto create(RegulatoryCapitalAdequacyReportDto dto);

    RegulatoryCapitalAdequacyReportDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RegulatoryCapitalAdequacyReportDto> listAll();
}
