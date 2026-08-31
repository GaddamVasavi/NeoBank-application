package com.neobank.notificationservice;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SmsGatewayAuditLogRepository extends JpaRepository<SmsGatewayAuditLog, UUID> {
    List<SmsGatewayAuditLog> findByUserId(UUID userId);
    Optional<SmsGatewayAuditLog> findByRegistryKey(String key);
    List<SmsGatewayAuditLog> findByDeliveryStatus(String status);
}
