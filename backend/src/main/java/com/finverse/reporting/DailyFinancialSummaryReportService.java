package com.finverse.reporting;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DailyFinancialSummaryReport
 */
public interface DailyFinancialSummaryReportService {

    List<DailyFinancialSummaryReportDto> getByTenant(UUID tenantId);

    List<DailyFinancialSummaryReportDto> getByUser(UUID userId);

    DailyFinancialSummaryReportDto create(DailyFinancialSummaryReportDto dto);

    DailyFinancialSummaryReportDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DailyFinancialSummaryReportDto> listAll();
}
