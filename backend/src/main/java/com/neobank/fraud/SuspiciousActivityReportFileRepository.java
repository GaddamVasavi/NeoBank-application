package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SuspiciousActivityReportFileRepository extends JpaRepository<SuspiciousActivityReportFile, UUID> {
    List<SuspiciousActivityReportFile> findByUserId(UUID userId);
    Optional<SuspiciousActivityReportFile> findByRecordKey(String recordKey);
    List<SuspiciousActivityReportFile> findByStatus(String status);
}
