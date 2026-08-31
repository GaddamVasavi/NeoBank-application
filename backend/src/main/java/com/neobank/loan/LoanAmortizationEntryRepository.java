package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanAmortizationEntryRepository extends JpaRepository<LoanAmortizationEntry, UUID> {
    List<LoanAmortizationEntry> findByUserId(UUID userId);
    Optional<LoanAmortizationEntry> findByRecordKey(String recordKey);
    List<LoanAmortizationEntry> findByStatus(String status);
}
