package com.neobank.paymentsgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WebhookNotificationAuditLogRepository extends JpaRepository<WebhookNotificationAuditLog, UUID> {
    List<WebhookNotificationAuditLog> findByUserId(UUID userId);
    Optional<WebhookNotificationAuditLog> findBySystemIdentifier(String id);
    List<WebhookNotificationAuditLog> findByValidationState(String state);
}
