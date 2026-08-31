package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AuditExportScheduleRepository extends JpaRepository<AuditExportSchedule, UUID> {
    List<AuditExportSchedule> findByUserId(UUID userId);
    Optional<AuditExportSchedule> findByRecordKey(String recordKey);
    List<AuditExportSchedule> findByStatus(String status);
}
