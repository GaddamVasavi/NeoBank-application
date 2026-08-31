package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AuditCommitteeCharterLogRepository extends JpaRepository<AuditCommitteeCharterLog, UUID> {
    List<AuditCommitteeCharterLog> findByUserId(UUID userId);
    Optional<AuditCommitteeCharterLog> findByInstitutionalRef(String ref);
    List<AuditCommitteeCharterLog> findByExecutionStatus(String status);
}
