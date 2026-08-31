package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DefinedContributionPlanRepository extends JpaRepository<DefinedContributionPlan, UUID> {
    List<DefinedContributionPlan> findByUserId(UUID userId);
    Optional<DefinedContributionPlan> findBySettlementRef(String ref);
    List<DefinedContributionPlan> findByLifecycleStatus(String status);
}
