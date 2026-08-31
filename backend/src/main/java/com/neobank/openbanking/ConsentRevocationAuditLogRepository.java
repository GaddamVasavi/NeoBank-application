package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ConsentRevocationAuditLogRepository extends JpaRepository<ConsentRevocationAuditLog, UUID> {
    List<ConsentRevocationAuditLog> findByUserId(UUID userId);
    Optional<ConsentRevocationAuditLog> findByTrackingCode(String code);
    List<ConsentRevocationAuditLog> findByStateFlag(String stateFlag);
}
