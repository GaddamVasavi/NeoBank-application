package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CrsTaxReportingRecordRepository extends JpaRepository<CrsTaxReportingRecord, UUID> {
    List<CrsTaxReportingRecord> findByUserId(UUID userId);
    Optional<CrsTaxReportingRecord> findByIdentifierCode(String code);
    List<CrsTaxReportingRecord> findByStatus(String status);
}
