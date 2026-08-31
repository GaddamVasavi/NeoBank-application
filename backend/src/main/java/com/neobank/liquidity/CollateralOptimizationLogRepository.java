package com.neobank.liquidity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CollateralOptimizationLogRepository extends JpaRepository<CollateralOptimizationLog, UUID> {
    List<CollateralOptimizationLog> findByUserId(UUID userId);
    Optional<CollateralOptimizationLog> findBySystemIdentifier(String id);
    List<CollateralOptimizationLog> findByValidationState(String state);
}
