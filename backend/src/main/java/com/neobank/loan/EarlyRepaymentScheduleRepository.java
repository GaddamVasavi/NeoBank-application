package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EarlyRepaymentScheduleRepository extends JpaRepository<EarlyRepaymentSchedule, UUID> {
    List<EarlyRepaymentSchedule> findByUserId(UUID userId);
    Optional<EarlyRepaymentSchedule> findByCodeReference(String ref);
    List<EarlyRepaymentSchedule> findByStatus(String status);
}
