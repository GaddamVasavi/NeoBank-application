package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterbankClearingSettlementBatchRepository extends JpaRepository<InterbankClearingSettlementBatch, UUID> {
    List<InterbankClearingSettlementBatch> findByUserId(UUID userId);
    Optional<InterbankClearingSettlementBatch> findByClearingIdentifier(String id);
    List<InterbankClearingSettlementBatch> findBySettlementStatus(String status);
}
