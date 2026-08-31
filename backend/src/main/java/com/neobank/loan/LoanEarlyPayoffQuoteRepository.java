package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanEarlyPayoffQuoteRepository extends JpaRepository<LoanEarlyPayoffQuote, UUID> {
    List<LoanEarlyPayoffQuote> findByUserId(UUID userId);
    Optional<LoanEarlyPayoffQuote> findByRecordKey(String recordKey);
    List<LoanEarlyPayoffQuote> findByStatus(String status);
}
