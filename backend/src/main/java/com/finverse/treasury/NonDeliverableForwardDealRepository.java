package com.finverse.treasury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for NonDeliverableForwardDeal
 */
@Repository
public interface NonDeliverableForwardDealRepository extends JpaRepository<NonDeliverableForwardDeal, UUID> {

    List<NonDeliverableForwardDeal> findByTenantId(UUID tenantId);

    List<NonDeliverableForwardDeal> findByUserId(UUID userId);

    Optional<NonDeliverableForwardDeal> findBySystemReference(String ref);

    List<NonDeliverableForwardDeal> findByOperationalStatus(String status);

    @Query("SELECT e FROM NonDeliverableForwardDeal e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<NonDeliverableForwardDeal> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
