package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LiquidityCoverageRatioMetricRepository extends JpaRepository<LiquidityCoverageRatioMetric, UUID> {
    List<LiquidityCoverageRatioMetric> findByUserId(UUID userId);
    Optional<LiquidityCoverageRatioMetric> findByTrackingCode(String code);
    List<LiquidityCoverageRatioMetric> findByStateFlag(String stateFlag);
}
