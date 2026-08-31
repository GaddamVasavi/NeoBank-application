package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantDomainMapping
 */
@Repository
public interface TenantDomainMappingRepository extends JpaRepository<TenantDomainMapping, UUID> {

    List<TenantDomainMapping> findByTenantId(UUID tenantId);

    List<TenantDomainMapping> findByUserId(UUID userId);

    Optional<TenantDomainMapping> findBySystemReference(String ref);

    List<TenantDomainMapping> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantDomainMapping e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantDomainMapping> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
