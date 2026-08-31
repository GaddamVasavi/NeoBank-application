package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentWebhookEventLog
 */
@Repository
public interface PaymentWebhookEventLogRepository extends JpaRepository<PaymentWebhookEventLog, UUID> {

    List<PaymentWebhookEventLog> findByTenantId(UUID tenantId);

    List<PaymentWebhookEventLog> findByUserId(UUID userId);

    Optional<PaymentWebhookEventLog> findBySystemReference(String ref);

    List<PaymentWebhookEventLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentWebhookEventLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentWebhookEventLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
