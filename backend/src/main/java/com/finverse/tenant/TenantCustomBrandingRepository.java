package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantCustomBranding
 */
@Repository
public interface TenantCustomBrandingRepository extends JpaRepository<TenantCustomBranding, UUID> {

    List<TenantCustomBranding> findByTenantId(UUID tenantId);

    List<TenantCustomBranding> findByUserId(UUID userId);

    Optional<TenantCustomBranding> findBySystemReference(String ref);

    List<TenantCustomBranding> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantCustomBranding e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantCustomBranding> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
