package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BiometricIdentityMatch
 */
@Repository
public interface BiometricIdentityMatchRepository extends JpaRepository<BiometricIdentityMatch, UUID> {

    List<BiometricIdentityMatch> findByTenantId(UUID tenantId);

    List<BiometricIdentityMatch> findByUserId(UUID userId);

    Optional<BiometricIdentityMatch> findBySystemReference(String ref);

    List<BiometricIdentityMatch> findByOperationalStatus(String status);

    @Query("SELECT e FROM BiometricIdentityMatch e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BiometricIdentityMatch> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
