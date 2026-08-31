package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SwiftMessageAuditLogRepository extends JpaRepository<SwiftMessageAuditLog, UUID> {
    List<SwiftMessageAuditLog> findByUserId(UUID userId);
    Optional<SwiftMessageAuditLog> findByTrackingCode(String code);
    List<SwiftMessageAuditLog> findByStateFlag(String stateFlag);
}
