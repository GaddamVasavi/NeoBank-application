package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface IntradayMarginCallRecordRepository extends JpaRepository<IntradayMarginCallRecord, UUID> {
    List<IntradayMarginCallRecord> findByUserId(UUID userId);
    Optional<IntradayMarginCallRecord> findByInstitutionalRef(String ref);
    List<IntradayMarginCallRecord> findByExecutionStatus(String status);
}
