package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SubscriptionDunningRetry
 */
@Repository
public interface SubscriptionDunningRetryRepository extends JpaRepository<SubscriptionDunningRetry, UUID> {

    List<SubscriptionDunningRetry> findByTenantId(UUID tenantId);

    List<SubscriptionDunningRetry> findByUserId(UUID userId);

    Optional<SubscriptionDunningRetry> findBySystemReference(String ref);

    List<SubscriptionDunningRetry> findByOperationalStatus(String status);

    @Query("SELECT e FROM SubscriptionDunningRetry e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SubscriptionDunningRetry> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
