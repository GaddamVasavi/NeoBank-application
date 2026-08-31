package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SubscriptionRenewalSchedule
 */
@Repository
public interface SubscriptionRenewalScheduleRepository extends JpaRepository<SubscriptionRenewalSchedule, UUID> {

    List<SubscriptionRenewalSchedule> findByTenantId(UUID tenantId);

    List<SubscriptionRenewalSchedule> findByUserId(UUID userId);

    Optional<SubscriptionRenewalSchedule> findBySystemReference(String ref);

    List<SubscriptionRenewalSchedule> findByOperationalStatus(String status);

    @Query("SELECT e FROM SubscriptionRenewalSchedule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SubscriptionRenewalSchedule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
