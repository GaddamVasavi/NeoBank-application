package com.finverse.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TenantProfileMaster
 */
@Repository
public interface TenantProfileMasterRepository extends JpaRepository<TenantProfileMaster, UUID> {

    List<TenantProfileMaster> findByTenantId(UUID tenantId);

    List<TenantProfileMaster> findByUserId(UUID userId);

    Optional<TenantProfileMaster> findBySystemReference(String ref);

    List<TenantProfileMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM TenantProfileMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TenantProfileMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
