package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentCaptureSettlement
 */
@Repository
public interface PaymentCaptureSettlementRepository extends JpaRepository<PaymentCaptureSettlement, UUID> {

    List<PaymentCaptureSettlement> findByTenantId(UUID tenantId);

    List<PaymentCaptureSettlement> findByUserId(UUID userId);

    Optional<PaymentCaptureSettlement> findBySystemReference(String ref);

    List<PaymentCaptureSettlement> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentCaptureSettlement e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentCaptureSettlement> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
