package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanRestructuringPlanRepository extends JpaRepository<LoanRestructuringPlan, UUID> {
    List<LoanRestructuringPlan> findByUserId(UUID userId);
    Optional<LoanRestructuringPlan> findByRecordKey(String recordKey);
    List<LoanRestructuringPlan> findByStatus(String status);
}
