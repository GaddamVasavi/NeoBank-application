package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MessageDeadLetterQueueItemRepository extends JpaRepository<MessageDeadLetterQueueItem, UUID> {
    List<MessageDeadLetterQueueItem> findByUserId(UUID userId);
    Optional<MessageDeadLetterQueueItem> findByDossierReference(String ref);
    List<MessageDeadLetterQueueItem> findByOperationalStatus(String status);
}
