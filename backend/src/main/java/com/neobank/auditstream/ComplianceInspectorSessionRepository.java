package com.neobank.auditstream;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ComplianceInspectorSessionRepository extends JpaRepository<ComplianceInspectorSession, UUID> {
    List<ComplianceInspectorSession> findByUserId(UUID userId);
    Optional<ComplianceInspectorSession> findByCoreReference(String ref);
    List<ComplianceInspectorSession> findByProcessingStatus(String status);
}
