package com.finverse.beneficiaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BulkPayoutBatchUpload
 */
@Repository
public interface BulkPayoutBatchUploadRepository extends JpaRepository<BulkPayoutBatchUpload, UUID> {

    List<BulkPayoutBatchUpload> findByTenantId(UUID tenantId);

    List<BulkPayoutBatchUpload> findByUserId(UUID userId);

    Optional<BulkPayoutBatchUpload> findBySystemReference(String ref);

    List<BulkPayoutBatchUpload> findByOperationalStatus(String status);

    @Query("SELECT e FROM BulkPayoutBatchUpload e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BulkPayoutBatchUpload> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
