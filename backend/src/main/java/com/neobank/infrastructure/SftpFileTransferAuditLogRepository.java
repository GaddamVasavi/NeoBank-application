package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SftpFileTransferAuditLogRepository extends JpaRepository<SftpFileTransferAuditLog, UUID> {
    List<SftpFileTransferAuditLog> findByUserId(UUID userId);
    Optional<SftpFileTransferAuditLog> findByDossierReference(String ref);
    List<SftpFileTransferAuditLog> findByOperationalStatus(String status);
}
