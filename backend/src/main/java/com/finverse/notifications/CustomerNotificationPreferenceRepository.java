package com.finverse.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CustomerNotificationPreference
 */
@Repository
public interface CustomerNotificationPreferenceRepository extends JpaRepository<CustomerNotificationPreference, UUID> {

    List<CustomerNotificationPreference> findByTenantId(UUID tenantId);

    List<CustomerNotificationPreference> findByUserId(UUID userId);

    Optional<CustomerNotificationPreference> findBySystemReference(String ref);

    List<CustomerNotificationPreference> findByOperationalStatus(String status);

    @Query("SELECT e FROM CustomerNotificationPreference e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CustomerNotificationPreference> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
