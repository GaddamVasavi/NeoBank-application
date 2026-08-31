package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ChargebackFraudEvidence
 */
@Repository
public interface ChargebackFraudEvidenceRepository extends JpaRepository<ChargebackFraudEvidence, UUID> {

    List<ChargebackFraudEvidence> findByTenantId(UUID tenantId);

    List<ChargebackFraudEvidence> findByUserId(UUID userId);

    Optional<ChargebackFraudEvidence> findBySystemReference(String ref);

    List<ChargebackFraudEvidence> findByOperationalStatus(String status);

    @Query("SELECT e FROM ChargebackFraudEvidence e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ChargebackFraudEvidence> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
