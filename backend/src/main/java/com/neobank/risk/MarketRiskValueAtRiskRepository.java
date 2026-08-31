package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MarketRiskValueAtRiskRepository extends JpaRepository<MarketRiskValueAtRisk, UUID> {
    List<MarketRiskValueAtRisk> findByUserId(UUID userId);
    Optional<MarketRiskValueAtRisk> findByTrackingCode(String code);
    List<MarketRiskValueAtRisk> findByStateFlag(String stateFlag);
}
