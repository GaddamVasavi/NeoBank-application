package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.time.LocalDate; import java.util.List; import java.util.UUID;
@Repository public interface ScheduledTransferRepository extends JpaRepository<ScheduledTransfer, UUID> {
    List<ScheduledTransfer> findByExecutionDateAndActiveTrue(LocalDate date);
    List<ScheduledTransfer> findBySourceAccountId(UUID accountId);
}
