package com.finverse.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DeviceFingerprintProfile
 */
@Repository
public interface DeviceFingerprintProfileRepository extends JpaRepository<DeviceFingerprintProfile, UUID> {

    List<DeviceFingerprintProfile> findByTenantId(UUID tenantId);

    List<DeviceFingerprintProfile> findByUserId(UUID userId);

    Optional<DeviceFingerprintProfile> findBySystemReference(String ref);

    List<DeviceFingerprintProfile> findByOperationalStatus(String status);

    @Query("SELECT e FROM DeviceFingerprintProfile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DeviceFingerprintProfile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
