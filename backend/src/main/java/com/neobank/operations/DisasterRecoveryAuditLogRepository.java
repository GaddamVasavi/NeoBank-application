package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DisasterRecoveryAuditLogRepository extends JpaRepository<DisasterRecoveryAuditLog, UUID> {
    List<DisasterRecoveryAuditLog> findByUserId(UUID userId);
    Optional<DisasterRecoveryAuditLog> findByTrackingCode(String code);
    List<DisasterRecoveryAuditLog> findByStateFlag(String stateFlag);
}
