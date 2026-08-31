package com.finverse.capitalmarkets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InflationIndexedBondAsset
 */
@Repository
public interface InflationIndexedBondAssetRepository extends JpaRepository<InflationIndexedBondAsset, UUID> {

    List<InflationIndexedBondAsset> findByTenantId(UUID tenantId);

    List<InflationIndexedBondAsset> findByUserId(UUID userId);

    Optional<InflationIndexedBondAsset> findBySystemReference(String ref);

    List<InflationIndexedBondAsset> findByOperationalStatus(String status);

    @Query("SELECT e FROM InflationIndexedBondAsset e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InflationIndexedBondAsset> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
