package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BillingHistoryReceipt
 */
@Repository
public interface BillingHistoryReceiptRepository extends JpaRepository<BillingHistoryReceipt, UUID> {

    List<BillingHistoryReceipt> findByTenantId(UUID tenantId);

    List<BillingHistoryReceipt> findByUserId(UUID userId);

    Optional<BillingHistoryReceipt> findBySystemReference(String ref);

    List<BillingHistoryReceipt> findByOperationalStatus(String status);

    @Query("SELECT e FROM BillingHistoryReceipt e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BillingHistoryReceipt> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
