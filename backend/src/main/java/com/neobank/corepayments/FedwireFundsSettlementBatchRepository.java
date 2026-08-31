package com.neobank.corepayments;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FedwireFundsSettlementBatchRepository extends JpaRepository<FedwireFundsSettlementBatch, UUID> {
    List<FedwireFundsSettlementBatch> findByUserId(UUID userId);
    Optional<FedwireFundsSettlementBatch> findByClearingKey(String key);
    List<FedwireFundsSettlementBatch> findByAuditStatus(String status);
}
