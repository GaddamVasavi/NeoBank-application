package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TrialBalanceSnapshotFile
 */
@Repository
public interface TrialBalanceSnapshotFileRepository extends JpaRepository<TrialBalanceSnapshotFile, UUID> {

    List<TrialBalanceSnapshotFile> findByTenantId(UUID tenantId);

    List<TrialBalanceSnapshotFile> findByUserId(UUID userId);

    Optional<TrialBalanceSnapshotFile> findBySystemReference(String ref);

    List<TrialBalanceSnapshotFile> findByOperationalStatus(String status);

    @Query("SELECT e FROM TrialBalanceSnapshotFile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TrialBalanceSnapshotFile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
