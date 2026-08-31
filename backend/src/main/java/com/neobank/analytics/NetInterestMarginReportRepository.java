package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NetInterestMarginReportRepository extends JpaRepository<NetInterestMarginReport, UUID> {
    List<NetInterestMarginReport> findByUserId(UUID userId);
    Optional<NetInterestMarginReport> findByRecordKey(String recordKey);
    List<NetInterestMarginReport> findByStatus(String status);
}
