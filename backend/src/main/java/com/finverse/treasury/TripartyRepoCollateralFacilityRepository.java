package com.finverse.treasury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TripartyRepoCollateralFacility
 */
@Repository
public interface TripartyRepoCollateralFacilityRepository extends JpaRepository<TripartyRepoCollateralFacility, UUID> {

    List<TripartyRepoCollateralFacility> findByTenantId(UUID tenantId);

    List<TripartyRepoCollateralFacility> findByUserId(UUID userId);

    Optional<TripartyRepoCollateralFacility> findBySystemReference(String ref);

    List<TripartyRepoCollateralFacility> findByOperationalStatus(String status);

    @Query("SELECT e FROM TripartyRepoCollateralFacility e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TripartyRepoCollateralFacility> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
