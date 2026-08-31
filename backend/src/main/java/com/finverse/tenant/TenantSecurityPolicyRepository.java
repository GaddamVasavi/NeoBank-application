package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantSecurityPolicy
 */
@Repository
public interface TenantSecurityPolicyRepository extends JpaRepository<TenantSecurityPolicy, UUID> {

    List<TenantSecurityPolicy> findByTenantId(UUID tenantId);

    List<TenantSecurityPolicy> findByUserId(UUID userId);

    Optional<TenantSecurityPolicy> findBySystemReference(String ref);

    List<TenantSecurityPolicy> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantSecurityPolicy e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantSecurityPolicy> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
