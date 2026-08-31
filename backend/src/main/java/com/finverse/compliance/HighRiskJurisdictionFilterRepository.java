package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for HighRiskJurisdictionFilter
 */
@Repository
public interface HighRiskJurisdictionFilterRepository extends JpaRepository<HighRiskJurisdictionFilter, UUID> {

    List<HighRiskJurisdictionFilter> findByTenantId(UUID tenantId);

    List<HighRiskJurisdictionFilter> findByUserId(UUID userId);

    Optional<HighRiskJurisdictionFilter> findBySystemReference(String ref);

    List<HighRiskJurisdictionFilter> findByOperationalStatus(String status);

    @Query("SELECT e FROM HighRiskJurisdictionFilter e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<HighRiskJurisdictionFilter> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
