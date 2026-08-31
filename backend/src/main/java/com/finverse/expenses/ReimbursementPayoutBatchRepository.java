package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ReimbursementPayoutBatch
 */
@Repository
public interface ReimbursementPayoutBatchRepository extends JpaRepository<ReimbursementPayoutBatch, UUID> {

    List<ReimbursementPayoutBatch> findByTenantId(UUID tenantId);

    List<ReimbursementPayoutBatch> findByUserId(UUID userId);

    Optional<ReimbursementPayoutBatch> findBySystemReference(String ref);

    List<ReimbursementPayoutBatch> findByOperationalStatus(String status);

    @Query("SELECT e FROM ReimbursementPayoutBatch e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ReimbursementPayoutBatch> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
