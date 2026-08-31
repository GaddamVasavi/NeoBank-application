package com.neobank.reconciliation;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BankFeedTransactionMatchRepository extends JpaRepository<BankFeedTransactionMatch, UUID> {
    List<BankFeedTransactionMatch> findByUserId(UUID userId);
    Optional<BankFeedTransactionMatch> findByCoreReference(String ref);
    List<BankFeedTransactionMatch> findByProcessingStatus(String status);
}
