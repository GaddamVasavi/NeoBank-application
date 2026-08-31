package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AuditTrailExportArchiveRepository extends JpaRepository<AuditTrailExportArchive, UUID> {
    List<AuditTrailExportArchive> findByUserId(UUID userId);
    Optional<AuditTrailExportArchive> findByIdentifierCode(String code);
    List<AuditTrailExportArchive> findByStatus(String status);
}
