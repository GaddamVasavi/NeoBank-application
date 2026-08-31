package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InvoiceHeaderMaster
 */
@Repository
public interface InvoiceHeaderMasterRepository extends JpaRepository<InvoiceHeaderMaster, UUID> {

    List<InvoiceHeaderMaster> findByTenantId(UUID tenantId);

    List<InvoiceHeaderMaster> findByUserId(UUID userId);

    Optional<InvoiceHeaderMaster> findBySystemReference(String ref);

    List<InvoiceHeaderMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM InvoiceHeaderMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InvoiceHeaderMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
