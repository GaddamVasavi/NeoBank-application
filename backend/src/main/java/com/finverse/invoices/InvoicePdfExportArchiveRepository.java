package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InvoicePdfExportArchive
 */
@Repository
public interface InvoicePdfExportArchiveRepository extends JpaRepository<InvoicePdfExportArchive, UUID> {

    List<InvoicePdfExportArchive> findByTenantId(UUID tenantId);

    List<InvoicePdfExportArchive> findByUserId(UUID userId);

    Optional<InvoicePdfExportArchive> findBySystemReference(String ref);

    List<InvoicePdfExportArchive> findByOperationalStatus(String status);

    @Query("SELECT e FROM InvoicePdfExportArchive e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InvoicePdfExportArchive> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
