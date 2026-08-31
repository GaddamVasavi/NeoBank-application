package com.finverse.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EmailDispatchQueueItem
 */
@Repository
public interface EmailDispatchQueueItemRepository extends JpaRepository<EmailDispatchQueueItem, UUID> {

    List<EmailDispatchQueueItem> findByTenantId(UUID tenantId);

    List<EmailDispatchQueueItem> findByUserId(UUID userId);

    Optional<EmailDispatchQueueItem> findBySystemReference(String ref);

    List<EmailDispatchQueueItem> findByOperationalStatus(String status);

    @Query("SELECT e FROM EmailDispatchQueueItem e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EmailDispatchQueueItem> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
