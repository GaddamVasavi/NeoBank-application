package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RegulatoryComplianceExportRepository extends JpaRepository<RegulatoryComplianceExport, UUID> {
    List<RegulatoryComplianceExport> findByUserId(UUID userId);
    Optional<RegulatoryComplianceExport> findByRecordKey(String recordKey);
    List<RegulatoryComplianceExport> findByStatus(String status);
}
