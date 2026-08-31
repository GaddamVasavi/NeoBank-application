package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SubscriptionPlanTier
 */
public interface SubscriptionPlanTierService {

    List<SubscriptionPlanTierDto> getByTenant(UUID tenantId);

    List<SubscriptionPlanTierDto> getByUser(UUID userId);

    SubscriptionPlanTierDto create(SubscriptionPlanTierDto dto);

    SubscriptionPlanTierDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SubscriptionPlanTierDto> listAll();
}
