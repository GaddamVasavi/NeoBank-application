package com.finverse.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InAppNotificationEvent
 */
@Repository
public interface InAppNotificationEventRepository extends JpaRepository<InAppNotificationEvent, UUID> {

    List<InAppNotificationEvent> findByTenantId(UUID tenantId);

    List<InAppNotificationEvent> findByUserId(UUID userId);

    Optional<InAppNotificationEvent> findBySystemReference(String ref);

    List<InAppNotificationEvent> findByOperationalStatus(String status);

    @Query("SELECT e FROM InAppNotificationEvent e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InAppNotificationEvent> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
