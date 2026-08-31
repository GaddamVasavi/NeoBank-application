package com.finverse.reporting;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RevenueFeeIncomeReport
 */
public interface RevenueFeeIncomeReportService {

    List<RevenueFeeIncomeReportDto> getByTenant(UUID tenantId);

    List<RevenueFeeIncomeReportDto> getByUser(UUID userId);

    RevenueFeeIncomeReportDto create(RevenueFeeIncomeReportDto dto);

    RevenueFeeIncomeReportDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RevenueFeeIncomeReportDto> listAll();
}
