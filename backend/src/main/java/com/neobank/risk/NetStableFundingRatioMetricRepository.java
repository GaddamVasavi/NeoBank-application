package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NetStableFundingRatioMetricRepository extends JpaRepository<NetStableFundingRatioMetric, UUID> {
    List<NetStableFundingRatioMetric> findByUserId(UUID userId);
    Optional<NetStableFundingRatioMetric> findByTrackingCode(String code);
    List<NetStableFundingRatioMetric> findByStateFlag(String stateFlag);
}
