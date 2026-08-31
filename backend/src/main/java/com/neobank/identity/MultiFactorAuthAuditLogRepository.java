package com.neobank.identity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MultiFactorAuthAuditLogRepository extends JpaRepository<MultiFactorAuthAuditLog, UUID> {
    List<MultiFactorAuthAuditLog> findByUserId(UUID userId);
    Optional<MultiFactorAuthAuditLog> findByRegistryKey(String key);
    List<MultiFactorAuthAuditLog> findByDeliveryStatus(String status);
}
