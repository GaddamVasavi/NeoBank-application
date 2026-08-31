package com.finverse.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SupportSlaBreachTracker
 */
@Repository
public interface SupportSlaBreachTrackerRepository extends JpaRepository<SupportSlaBreachTracker, UUID> {

    List<SupportSlaBreachTracker> findByTenantId(UUID tenantId);

    List<SupportSlaBreachTracker> findByUserId(UUID userId);

    Optional<SupportSlaBreachTracker> findBySystemReference(String ref);

    List<SupportSlaBreachTracker> findByOperationalStatus(String status);

    @Query("SELECT e FROM SupportSlaBreachTracker e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SupportSlaBreachTracker> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
