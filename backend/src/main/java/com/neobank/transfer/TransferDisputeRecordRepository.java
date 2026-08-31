package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TransferDisputeRecordRepository extends JpaRepository<TransferDisputeRecord, UUID> {
    List<TransferDisputeRecord> findBySourceAccountId(UUID accountId);
    Optional<TransferDisputeRecord> findByTrackingNumber(String trackingNumber);
    List<TransferDisputeRecord> findByStatus(String status);
}
