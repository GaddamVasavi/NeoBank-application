package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ThreeWayLedgerReconBreak
 */
@Repository
public interface ThreeWayLedgerReconBreakRepository extends JpaRepository<ThreeWayLedgerReconBreak, UUID> {

    List<ThreeWayLedgerReconBreak> findByTenantId(UUID tenantId);

    List<ThreeWayLedgerReconBreak> findByUserId(UUID userId);

    Optional<ThreeWayLedgerReconBreak> findBySystemReference(String ref);

    List<ThreeWayLedgerReconBreak> findByOperationalStatus(String status);

    @Query("SELECT e FROM ThreeWayLedgerReconBreak e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ThreeWayLedgerReconBreak> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
