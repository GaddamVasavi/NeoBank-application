package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TargetDateRetirementFundRepository extends JpaRepository<TargetDateRetirementFund, UUID> {
    List<TargetDateRetirementFund> findByUserId(UUID userId);
    Optional<TargetDateRetirementFund> findBySettlementRef(String ref);
    List<TargetDateRetirementFund> findByLifecycleStatus(String status);
}
