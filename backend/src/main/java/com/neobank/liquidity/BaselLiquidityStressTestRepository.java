package com.neobank.liquidity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BaselLiquidityStressTestRepository extends JpaRepository<BaselLiquidityStressTest, UUID> {
    List<BaselLiquidityStressTest> findByUserId(UUID userId);
    Optional<BaselLiquidityStressTest> findBySystemIdentifier(String id);
    List<BaselLiquidityStressTest> findByValidationState(String state);
}
