package com.finverse.notifications;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InAppNotificationEvent
 */
public interface InAppNotificationEventService {

    List<InAppNotificationEventDto> getByTenant(UUID tenantId);

    List<InAppNotificationEventDto> getByUser(UUID userId);

    InAppNotificationEventDto create(InAppNotificationEventDto dto);

    InAppNotificationEventDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InAppNotificationEventDto> listAll();
}
