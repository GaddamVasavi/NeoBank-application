package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanDelinquencyTrackerRepository extends JpaRepository<LoanDelinquencyTracker, UUID> {
    List<LoanDelinquencyTracker> findByUserId(UUID userId);
    Optional<LoanDelinquencyTracker> findByRecordKey(String recordKey);
    List<LoanDelinquencyTracker> findByStatus(String status);
}
