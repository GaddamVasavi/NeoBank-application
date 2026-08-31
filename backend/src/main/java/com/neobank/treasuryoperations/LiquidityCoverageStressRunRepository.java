package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LiquidityCoverageStressRunRepository extends JpaRepository<LiquidityCoverageStressRun, UUID> {
    List<LiquidityCoverageStressRun> findByUserId(UUID userId);
    Optional<LiquidityCoverageStressRun> findByClearingIdentifier(String id);
    List<LiquidityCoverageStressRun> findBySettlementStatus(String status);
}
