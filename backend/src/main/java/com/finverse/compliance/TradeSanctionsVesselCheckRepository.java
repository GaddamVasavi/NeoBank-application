package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TradeSanctionsVesselCheck
 */
@Repository
public interface TradeSanctionsVesselCheckRepository extends JpaRepository<TradeSanctionsVesselCheck, UUID> {

    List<TradeSanctionsVesselCheck> findByTenantId(UUID tenantId);

    List<TradeSanctionsVesselCheck> findByUserId(UUID userId);

    Optional<TradeSanctionsVesselCheck> findBySystemReference(String ref);

    List<TradeSanctionsVesselCheck> findByOperationalStatus(String status);

    @Query("SELECT e FROM TradeSanctionsVesselCheck e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TradeSanctionsVesselCheck> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
