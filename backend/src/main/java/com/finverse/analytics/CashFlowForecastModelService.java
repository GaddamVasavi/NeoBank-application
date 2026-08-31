package com.finverse.analytics;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CashFlowForecastModel
 */
public interface CashFlowForecastModelService {

    List<CashFlowForecastModelDto> getByTenant(UUID tenantId);

    List<CashFlowForecastModelDto> getByUser(UUID userId);

    CashFlowForecastModelDto create(CashFlowForecastModelDto dto);

    CashFlowForecastModelDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CashFlowForecastModelDto> listAll();
}
