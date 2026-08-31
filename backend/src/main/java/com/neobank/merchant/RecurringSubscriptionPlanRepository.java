package com.neobank.merchant;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RecurringSubscriptionPlanRepository extends JpaRepository<RecurringSubscriptionPlan, UUID> {
    List<RecurringSubscriptionPlan> findByUserId(UUID userId);
    Optional<RecurringSubscriptionPlan> findByCoreReference(String ref);
    List<RecurringSubscriptionPlan> findByProcessingStatus(String status);
}
