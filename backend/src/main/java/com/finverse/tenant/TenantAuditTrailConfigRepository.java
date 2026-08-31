package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantAuditTrailConfig
 */
@Repository
public interface TenantAuditTrailConfigRepository extends JpaRepository<TenantAuditTrailConfig, UUID> {

    List<TenantAuditTrailConfig> findByTenantId(UUID tenantId);

    List<TenantAuditTrailConfig> findByUserId(UUID userId);

    Optional<TenantAuditTrailConfig> findBySystemReference(String ref);

    List<TenantAuditTrailConfig> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantAuditTrailConfig e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantAuditTrailConfig> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
