package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SubscriptionRenewalSchedule
 */
public interface SubscriptionRenewalScheduleService {

    List<SubscriptionRenewalScheduleDto> getByTenant(UUID tenantId);

    List<SubscriptionRenewalScheduleDto> getByUser(UUID userId);

    SubscriptionRenewalScheduleDto create(SubscriptionRenewalScheduleDto dto);

    SubscriptionRenewalScheduleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SubscriptionRenewalScheduleDto> listAll();
}
