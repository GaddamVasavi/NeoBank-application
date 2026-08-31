package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DistributedLockAuditLogRepository extends JpaRepository<DistributedLockAuditLog, UUID> {
    List<DistributedLockAuditLog> findByUserId(UUID userId);
    Optional<DistributedLockAuditLog> findByDossierReference(String ref);
    List<DistributedLockAuditLog> findByOperationalStatus(String status);
}
