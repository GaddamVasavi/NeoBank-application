package com.finverse.privateequity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DistributionWaterfallLedger
 */
@Repository
public interface DistributionWaterfallLedgerRepository extends JpaRepository<DistributionWaterfallLedger, UUID> {

    List<DistributionWaterfallLedger> findByTenantId(UUID tenantId);

    List<DistributionWaterfallLedger> findByUserId(UUID userId);

    Optional<DistributionWaterfallLedger> findBySystemReference(String ref);

    List<DistributionWaterfallLedger> findByOperationalStatus(String status);

    @Query("SELECT e FROM DistributionWaterfallLedger e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DistributionWaterfallLedger> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
