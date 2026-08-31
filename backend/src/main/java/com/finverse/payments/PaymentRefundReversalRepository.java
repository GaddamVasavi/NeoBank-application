package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentRefundReversal
 */
@Repository
public interface PaymentRefundReversalRepository extends JpaRepository<PaymentRefundReversal, UUID> {

    List<PaymentRefundReversal> findByTenantId(UUID tenantId);

    List<PaymentRefundReversal> findByUserId(UUID userId);

    Optional<PaymentRefundReversal> findBySystemReference(String ref);

    List<PaymentRefundReversal> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentRefundReversal e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentRefundReversal> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
