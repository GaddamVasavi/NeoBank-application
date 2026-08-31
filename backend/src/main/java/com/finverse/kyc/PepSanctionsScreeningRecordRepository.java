package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PepSanctionsScreeningRecord
 */
@Repository
public interface PepSanctionsScreeningRecordRepository extends JpaRepository<PepSanctionsScreeningRecord, UUID> {

    List<PepSanctionsScreeningRecord> findByTenantId(UUID tenantId);

    List<PepSanctionsScreeningRecord> findByUserId(UUID userId);

    Optional<PepSanctionsScreeningRecord> findBySystemReference(String ref);

    List<PepSanctionsScreeningRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM PepSanctionsScreeningRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PepSanctionsScreeningRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
