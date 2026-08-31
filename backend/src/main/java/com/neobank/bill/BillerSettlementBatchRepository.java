package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BillerSettlementBatchRepository extends JpaRepository<BillerSettlementBatch, UUID> {
    List<BillerSettlementBatch> findByUserId(UUID userId);
    Optional<BillerSettlementBatch> findByRecordKey(String recordKey);
    List<BillerSettlementBatch> findByStatus(String status);
}
