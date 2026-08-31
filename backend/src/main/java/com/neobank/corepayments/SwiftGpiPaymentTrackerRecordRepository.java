package com.neobank.corepayments;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SwiftGpiPaymentTrackerRecordRepository extends JpaRepository<SwiftGpiPaymentTrackerRecord, UUID> {
    List<SwiftGpiPaymentTrackerRecord> findByUserId(UUID userId);
    Optional<SwiftGpiPaymentTrackerRecord> findByClearingKey(String key);
    List<SwiftGpiPaymentTrackerRecord> findByAuditStatus(String status);
}
