package com.neobank.bonds;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BondYieldSpreadMetricRecordRepository extends JpaRepository<BondYieldSpreadMetricRecord, UUID> {
    List<BondYieldSpreadMetricRecord> findByUserId(UUID userId);
    Optional<BondYieldSpreadMetricRecord> findByClearingKey(String key);
    List<BondYieldSpreadMetricRecord> findByAuditStatus(String status);
}
