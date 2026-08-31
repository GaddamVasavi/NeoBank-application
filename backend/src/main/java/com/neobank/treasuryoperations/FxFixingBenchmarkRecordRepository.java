package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FxFixingBenchmarkRecordRepository extends JpaRepository<FxFixingBenchmarkRecord, UUID> {
    List<FxFixingBenchmarkRecord> findByUserId(UUID userId);
    Optional<FxFixingBenchmarkRecord> findByClearingIdentifier(String id);
    List<FxFixingBenchmarkRecord> findBySettlementStatus(String status);
}
