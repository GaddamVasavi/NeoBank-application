package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RecurringBillSchedulerRepository extends JpaRepository<RecurringBillScheduler, UUID> {
    List<RecurringBillScheduler> findByUserId(UUID userId);
    Optional<RecurringBillScheduler> findByRecordKey(String recordKey);
    List<RecurringBillScheduler> findByStatus(String status);
}
