package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for KycVerificationCase
 */
@Repository
public interface KycVerificationCaseRepository extends JpaRepository<KycVerificationCase, UUID> {

    List<KycVerificationCase> findByTenantId(UUID tenantId);

    List<KycVerificationCase> findByUserId(UUID userId);

    Optional<KycVerificationCase> findBySystemReference(String ref);

    List<KycVerificationCase> findByOperationalStatus(String status);

    @Query("SELECT e FROM KycVerificationCase e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<KycVerificationCase> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
