package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PostRetirementDrawdownPlanRepository extends JpaRepository<PostRetirementDrawdownPlan, UUID> {
    List<PostRetirementDrawdownPlan> findByUserId(UUID userId);
    Optional<PostRetirementDrawdownPlan> findBySettlementRef(String ref);
    List<PostRetirementDrawdownPlan> findByLifecycleStatus(String status);
}
