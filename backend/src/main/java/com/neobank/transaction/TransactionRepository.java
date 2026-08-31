package com.neobank.transaction;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    Page<Transaction> findByAccountIdOrderByTransactionDateDesc(UUID accountId, Pageable pageable);
    List<Transaction> findTop10ByAccountIdOrderByTransactionDateDesc(UUID accountId);
    Optional<Transaction> findByReferenceNumber(String refNumber);
}
