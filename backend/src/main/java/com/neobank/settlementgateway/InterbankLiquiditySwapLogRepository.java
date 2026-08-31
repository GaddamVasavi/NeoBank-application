package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterbankLiquiditySwapLogRepository extends JpaRepository<InterbankLiquiditySwapLog, UUID> {
    List<InterbankLiquiditySwapLog> findByUserId(UUID userId);
    Optional<InterbankLiquiditySwapLog> findByGatewayReference(String ref);
    List<InterbankLiquiditySwapLog> findBySettlementState(String state);
}
