package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SubscriptionPlanTier
 */
@Repository
public interface SubscriptionPlanTierRepository extends JpaRepository<SubscriptionPlanTier, UUID> {

    List<SubscriptionPlanTier> findByTenantId(UUID tenantId);

    List<SubscriptionPlanTier> findByUserId(UUID userId);

    Optional<SubscriptionPlanTier> findBySystemReference(String ref);

    List<SubscriptionPlanTier> findByOperationalStatus(String status);

    @Query("SELECT e FROM SubscriptionPlanTier e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SubscriptionPlanTier> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
