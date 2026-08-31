package com.finverse.notifications;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CustomerNotificationPreference
 */
public interface CustomerNotificationPreferenceService {

    List<CustomerNotificationPreferenceDto> getByTenant(UUID tenantId);

    List<CustomerNotificationPreferenceDto> getByUser(UUID userId);

    CustomerNotificationPreferenceDto create(CustomerNotificationPreferenceDto dto);

    CustomerNotificationPreferenceDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CustomerNotificationPreferenceDto> listAll();
}
