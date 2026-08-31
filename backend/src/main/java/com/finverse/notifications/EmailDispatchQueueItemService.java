package com.finverse.notifications;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EmailDispatchQueueItem
 */
public interface EmailDispatchQueueItemService {

    List<EmailDispatchQueueItemDto> getByTenant(UUID tenantId);

    List<EmailDispatchQueueItemDto> getByUser(UUID userId);

    EmailDispatchQueueItemDto create(EmailDispatchQueueItemDto dto);

    EmailDispatchQueueItemDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EmailDispatchQueueItemDto> listAll();
}
