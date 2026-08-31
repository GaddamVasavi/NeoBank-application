package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SaaSSubscriptionContract
 */
@Repository
public interface SaaSSubscriptionContractRepository extends JpaRepository<SaaSSubscriptionContract, UUID> {

    List<SaaSSubscriptionContract> findByTenantId(UUID tenantId);

    List<SaaSSubscriptionContract> findByUserId(UUID userId);

    Optional<SaaSSubscriptionContract> findBySystemReference(String ref);

    List<SaaSSubscriptionContract> findByOperationalStatus(String status);

    @Query("SELECT e FROM SaaSSubscriptionContract e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SaaSSubscriptionContract> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
