package com.finverse.custody;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DividendReinvestmentPlan
 */
public interface DividendReinvestmentPlanService {

    List<DividendReinvestmentPlanDto> getByTenant(UUID tenantId);

    List<DividendReinvestmentPlanDto> getByUser(UUID userId);

    DividendReinvestmentPlanDto create(DividendReinvestmentPlanDto dto);

    DividendReinvestmentPlanDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DividendReinvestmentPlanDto> listAll();
}
