package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentReceiptDossier
 */
@Repository
public interface PaymentReceiptDossierRepository extends JpaRepository<PaymentReceiptDossier, UUID> {

    List<PaymentReceiptDossier> findByTenantId(UUID tenantId);

    List<PaymentReceiptDossier> findByUserId(UUID userId);

    Optional<PaymentReceiptDossier> findBySystemReference(String ref);

    List<PaymentReceiptDossier> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentReceiptDossier e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentReceiptDossier> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
