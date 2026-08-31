package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RecurringInvoiceProfile
 */
@Repository
public interface RecurringInvoiceProfileRepository extends JpaRepository<RecurringInvoiceProfile, UUID> {

    List<RecurringInvoiceProfile> findByTenantId(UUID tenantId);

    List<RecurringInvoiceProfile> findByUserId(UUID userId);

    Optional<RecurringInvoiceProfile> findBySystemReference(String ref);

    List<RecurringInvoiceProfile> findByOperationalStatus(String status);

    @Query("SELECT e FROM RecurringInvoiceProfile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RecurringInvoiceProfile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
