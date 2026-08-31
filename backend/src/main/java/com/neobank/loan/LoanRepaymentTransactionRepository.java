package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanRepaymentTransactionRepository extends JpaRepository<LoanRepaymentTransaction, UUID> {
    List<LoanRepaymentTransaction> findByUserId(UUID userId);
    Optional<LoanRepaymentTransaction> findByRecordKey(String recordKey);
    List<LoanRepaymentTransaction> findByStatus(String status);
}
