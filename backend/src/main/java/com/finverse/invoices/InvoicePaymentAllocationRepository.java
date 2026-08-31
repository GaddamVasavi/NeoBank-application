package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InvoicePaymentAllocation
 */
@Repository
public interface InvoicePaymentAllocationRepository extends JpaRepository<InvoicePaymentAllocation, UUID> {

    List<InvoicePaymentAllocation> findByTenantId(UUID tenantId);

    List<InvoicePaymentAllocation> findByUserId(UUID userId);

    Optional<InvoicePaymentAllocation> findBySystemReference(String ref);

    List<InvoicePaymentAllocation> findByOperationalStatus(String status);

    @Query("SELECT e FROM InvoicePaymentAllocation e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InvoicePaymentAllocation> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
