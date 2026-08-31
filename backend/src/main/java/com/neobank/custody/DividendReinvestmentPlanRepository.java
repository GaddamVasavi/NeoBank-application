package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DividendReinvestmentPlanRepository extends JpaRepository<DividendReinvestmentPlan, UUID> {
    List<DividendReinvestmentPlan> findByUserId(UUID userId);
    Optional<DividendReinvestmentPlan> findBySettlementRef(String ref);
    List<DividendReinvestmentPlan> findByLifecycleStatus(String status);
}
