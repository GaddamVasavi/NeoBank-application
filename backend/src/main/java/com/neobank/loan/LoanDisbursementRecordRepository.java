package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanDisbursementRecordRepository extends JpaRepository<LoanDisbursementRecord, UUID> {
    List<LoanDisbursementRecord> findByUserId(UUID userId);
    Optional<LoanDisbursementRecord> findByRecordKey(String recordKey);
    List<LoanDisbursementRecord> findByStatus(String status);
}
