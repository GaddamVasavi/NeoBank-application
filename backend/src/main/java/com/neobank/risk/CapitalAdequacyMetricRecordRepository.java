package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CapitalAdequacyMetricRecordRepository extends JpaRepository<CapitalAdequacyMetricRecord, UUID> {
    List<CapitalAdequacyMetricRecord> findByUserId(UUID userId);
    Optional<CapitalAdequacyMetricRecord> findByTrackingCode(String code);
    List<CapitalAdequacyMetricRecord> findByStateFlag(String stateFlag);
}
