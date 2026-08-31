package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for JournalEntryBatchMaster
 */
@Repository
public interface JournalEntryBatchMasterRepository extends JpaRepository<JournalEntryBatchMaster, UUID> {

    List<JournalEntryBatchMaster> findByTenantId(UUID tenantId);

    List<JournalEntryBatchMaster> findByUserId(UUID userId);

    Optional<JournalEntryBatchMaster> findBySystemReference(String ref);

    List<JournalEntryBatchMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM JournalEntryBatchMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<JournalEntryBatchMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
