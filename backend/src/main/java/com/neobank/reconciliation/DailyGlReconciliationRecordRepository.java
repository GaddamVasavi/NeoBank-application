package com.neobank.reconciliation;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DailyGlReconciliationRecordRepository extends JpaRepository<DailyGlReconciliationRecord, UUID> {
    List<DailyGlReconciliationRecord> findByUserId(UUID userId);
    Optional<DailyGlReconciliationRecord> findByCoreReference(String ref);
    List<DailyGlReconciliationRecord> findByProcessingStatus(String status);
}
