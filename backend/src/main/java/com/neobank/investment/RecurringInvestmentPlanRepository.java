package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RecurringInvestmentPlanRepository extends JpaRepository<RecurringInvestmentPlan, UUID> {
    List<RecurringInvestmentPlan> findByUserId(UUID userId);
    Optional<RecurringInvestmentPlan> findByIdentifierCode(String code);
    List<RecurringInvestmentPlan> findByStatus(String status);
}
