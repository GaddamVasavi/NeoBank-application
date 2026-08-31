package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ReconciliationExceptionRecordRepository extends JpaRepository<ReconciliationExceptionRecord, UUID> {
    List<ReconciliationExceptionRecord> findByUserId(UUID userId);
    Optional<ReconciliationExceptionRecord> findByTrackingCode(String code);
    List<ReconciliationExceptionRecord> findByStateFlag(String stateFlag);
}
