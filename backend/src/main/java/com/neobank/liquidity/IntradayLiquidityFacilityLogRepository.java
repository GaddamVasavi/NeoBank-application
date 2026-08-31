package com.neobank.liquidity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface IntradayLiquidityFacilityLogRepository extends JpaRepository<IntradayLiquidityFacilityLog, UUID> {
    List<IntradayLiquidityFacilityLog> findByUserId(UUID userId);
    Optional<IntradayLiquidityFacilityLog> findBySystemIdentifier(String id);
    List<IntradayLiquidityFacilityLog> findByValidationState(String state);
}
