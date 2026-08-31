package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SourceOfFundsAttestation
 */
@Repository
public interface SourceOfFundsAttestationRepository extends JpaRepository<SourceOfFundsAttestation, UUID> {

    List<SourceOfFundsAttestation> findByTenantId(UUID tenantId);

    List<SourceOfFundsAttestation> findByUserId(UUID userId);

    Optional<SourceOfFundsAttestation> findBySystemReference(String ref);

    List<SourceOfFundsAttestation> findByOperationalStatus(String status);

    @Query("SELECT e FROM SourceOfFundsAttestation e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SourceOfFundsAttestation> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
