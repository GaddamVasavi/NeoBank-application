package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SubscriptionDunningRetry
 */
public interface SubscriptionDunningRetryService {

    List<SubscriptionDunningRetryDto> getByTenant(UUID tenantId);

    List<SubscriptionDunningRetryDto> getByUser(UUID userId);

    SubscriptionDunningRetryDto create(SubscriptionDunningRetryDto dto);

    SubscriptionDunningRetryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SubscriptionDunningRetryDto> listAll();
}
