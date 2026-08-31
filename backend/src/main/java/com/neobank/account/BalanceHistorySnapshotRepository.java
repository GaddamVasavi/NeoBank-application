package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BalanceHistorySnapshotRepository extends JpaRepository<BalanceHistorySnapshot, UUID> {
    List<BalanceHistorySnapshot> findByAccountId(UUID accountId);
    Optional<BalanceHistorySnapshot> findByReferenceCode(String ref);
    List<BalanceHistorySnapshot> findByStatus(String status);
}
