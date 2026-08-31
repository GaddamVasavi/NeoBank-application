package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CollateralPledgeRegistry
 */
@Repository
public interface CollateralPledgeRegistryRepository extends JpaRepository<CollateralPledgeRegistry, UUID> {

    List<CollateralPledgeRegistry> findByTenantId(UUID tenantId);

    List<CollateralPledgeRegistry> findByUserId(UUID userId);

    Optional<CollateralPledgeRegistry> findBySystemReference(String ref);

    List<CollateralPledgeRegistry> findByOperationalStatus(String status);

    @Query("SELECT e FROM CollateralPledgeRegistry e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CollateralPledgeRegistry> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
