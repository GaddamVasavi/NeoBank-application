package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantSubscriptionPlan
 */
public interface TenantSubscriptionPlanService {

    List<TenantSubscriptionPlanDto> getByTenant(UUID tenantId);

    List<TenantSubscriptionPlanDto> getByUser(UUID userId);

    TenantSubscriptionPlanDto create(TenantSubscriptionPlanDto dto);

    TenantSubscriptionPlanDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantSubscriptionPlanDto> listAll();
}
