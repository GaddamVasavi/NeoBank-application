package com.finverse.reporting;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TaxWithholdingSummaryReport
 */
public interface TaxWithholdingSummaryReportService {

    List<TaxWithholdingSummaryReportDto> getByTenant(UUID tenantId);

    List<TaxWithholdingSummaryReportDto> getByUser(UUID userId);

    TaxWithholdingSummaryReportDto create(TaxWithholdingSummaryReportDto dto);

    TaxWithholdingSummaryReportDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TaxWithholdingSummaryReportDto> listAll();
}
