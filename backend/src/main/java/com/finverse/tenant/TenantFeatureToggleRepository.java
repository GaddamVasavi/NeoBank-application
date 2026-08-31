package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantFeatureToggle
 */
@Repository
public interface TenantFeatureToggleRepository extends JpaRepository<TenantFeatureToggle, UUID> {

    List<TenantFeatureToggle> findByTenantId(UUID tenantId);

    List<TenantFeatureToggle> findByUserId(UUID userId);

    Optional<TenantFeatureToggle> findBySystemReference(String ref);

    List<TenantFeatureToggle> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantFeatureToggle e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantFeatureToggle> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
