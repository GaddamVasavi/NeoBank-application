package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RecurringTransferRuleRepository extends JpaRepository<RecurringTransferRule, UUID> {
    List<RecurringTransferRule> findBySourceAccountId(UUID accountId);
    Optional<RecurringTransferRule> findByTrackingNumber(String trackingNumber);
    List<RecurringTransferRule> findByStatus(String status);
}
