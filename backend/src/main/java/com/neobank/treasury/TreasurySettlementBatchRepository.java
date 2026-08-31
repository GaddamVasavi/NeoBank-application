package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TreasurySettlementBatchRepository extends JpaRepository<TreasurySettlementBatch, UUID> {
    List<TreasurySettlementBatch> findByUserId(UUID userId);
    Optional<TreasurySettlementBatch> findByIdentifierCode(String code);
    List<TreasurySettlementBatch> findByStatus(String status);
}
