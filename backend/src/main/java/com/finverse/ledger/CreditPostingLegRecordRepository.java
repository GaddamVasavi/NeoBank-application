package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CreditPostingLegRecord
 */
@Repository
public interface CreditPostingLegRecordRepository extends JpaRepository<CreditPostingLegRecord, UUID> {

    List<CreditPostingLegRecord> findByTenantId(UUID tenantId);

    List<CreditPostingLegRecord> findByUserId(UUID userId);

    Optional<CreditPostingLegRecord> findBySystemReference(String ref);

    List<CreditPostingLegRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM CreditPostingLegRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CreditPostingLegRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
