package com.finverse.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantLifecycleManagement
 */
@Repository
public interface TenantLifecycleManagementRepository extends JpaRepository<TenantLifecycleManagement, UUID> {

    List<TenantLifecycleManagement> findByTenantId(UUID tenantId);

    List<TenantLifecycleManagement> findByUserId(UUID userId);

    Optional<TenantLifecycleManagement> findBySystemReference(String ref);

    List<TenantLifecycleManagement> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantLifecycleManagement e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantLifecycleManagement> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
