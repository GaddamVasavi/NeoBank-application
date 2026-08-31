package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DebitPostingLegRecord
 */
@Repository
public interface DebitPostingLegRecordRepository extends JpaRepository<DebitPostingLegRecord, UUID> {

    List<DebitPostingLegRecord> findByTenantId(UUID tenantId);

    List<DebitPostingLegRecord> findByUserId(UUID userId);

    Optional<DebitPostingLegRecord> findBySystemReference(String ref);

    List<DebitPostingLegRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM DebitPostingLegRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DebitPostingLegRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
