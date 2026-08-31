package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InvoiceLineItemRecord
 */
@Repository
public interface InvoiceLineItemRecordRepository extends JpaRepository<InvoiceLineItemRecord, UUID> {

    List<InvoiceLineItemRecord> findByTenantId(UUID tenantId);

    List<InvoiceLineItemRecord> findByUserId(UUID userId);

    Optional<InvoiceLineItemRecord> findBySystemReference(String ref);

    List<InvoiceLineItemRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM InvoiceLineItemRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InvoiceLineItemRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
