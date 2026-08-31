package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface MessageDeadLetterQueueItemService {
    List<MessageDeadLetterQueueItemDto> getByUser(UUID userId);
    MessageDeadLetterQueueItemDto create(MessageDeadLetterQueueItemDto dto);
    MessageDeadLetterQueueItemDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<MessageDeadLetterQueueItemDto> listAll();
}
