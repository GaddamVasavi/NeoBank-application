package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantSubscriptionPlan
 */
@Repository
public interface TenantSubscriptionPlanRepository extends JpaRepository<TenantSubscriptionPlan, UUID> {

    List<TenantSubscriptionPlan> findByTenantId(UUID tenantId);

    List<TenantSubscriptionPlan> findByUserId(UUID userId);

    Optional<TenantSubscriptionPlan> findBySystemReference(String ref);

    List<TenantSubscriptionPlan> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantSubscriptionPlan e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantSubscriptionPlan> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
