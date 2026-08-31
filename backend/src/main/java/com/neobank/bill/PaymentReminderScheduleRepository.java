package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PaymentReminderScheduleRepository extends JpaRepository<PaymentReminderSchedule, UUID> {
    List<PaymentReminderSchedule> findByUserId(UUID userId);
    Optional<PaymentReminderSchedule> findByRecordKey(String recordKey);
    List<PaymentReminderSchedule> findByStatus(String status);
}
