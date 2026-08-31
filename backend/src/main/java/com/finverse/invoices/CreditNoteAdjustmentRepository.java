package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CreditNoteAdjustment
 */
@Repository
public interface CreditNoteAdjustmentRepository extends JpaRepository<CreditNoteAdjustment, UUID> {

    List<CreditNoteAdjustment> findByTenantId(UUID tenantId);

    List<CreditNoteAdjustment> findByUserId(UUID userId);

    Optional<CreditNoteAdjustment> findBySystemReference(String ref);

    List<CreditNoteAdjustment> findByOperationalStatus(String status);

    @Query("SELECT e FROM CreditNoteAdjustment e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CreditNoteAdjustment> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
