package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FxMarginRequirementMetricRepository extends JpaRepository<FxMarginRequirementMetric, UUID> {
    List<FxMarginRequirementMetric> findByUserId(UUID userId);
    Optional<FxMarginRequirementMetric> findBySettlementRef(String ref);
    List<FxMarginRequirementMetric> findByLifecycleStatus(String status);
}
