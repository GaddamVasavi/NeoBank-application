package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SlippageToleranceRuleRepository extends JpaRepository<SlippageToleranceRule, UUID> {
    List<SlippageToleranceRule> findByUserId(UUID userId);
    Optional<SlippageToleranceRule> findBySettlementRef(String ref);
    List<SlippageToleranceRule> findByLifecycleStatus(String status);
}
