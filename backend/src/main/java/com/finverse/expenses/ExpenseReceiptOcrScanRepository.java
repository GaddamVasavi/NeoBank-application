package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ExpenseReceiptOcrScan
 */
@Repository
public interface ExpenseReceiptOcrScanRepository extends JpaRepository<ExpenseReceiptOcrScan, UUID> {

    List<ExpenseReceiptOcrScan> findByTenantId(UUID tenantId);

    List<ExpenseReceiptOcrScan> findByUserId(UUID userId);

    Optional<ExpenseReceiptOcrScan> findBySystemReference(String ref);

    List<ExpenseReceiptOcrScan> findByOperationalStatus(String status);

    @Query("SELECT e FROM ExpenseReceiptOcrScan e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ExpenseReceiptOcrScan> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
