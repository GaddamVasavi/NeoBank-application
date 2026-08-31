package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SovereignDebtYieldCurveRepository extends JpaRepository<SovereignDebtYieldCurve, UUID> {
    List<SovereignDebtYieldCurve> findByUserId(UUID userId);
    Optional<SovereignDebtYieldCurve> findByClearingIdentifier(String id);
    List<SovereignDebtYieldCurve> findBySettlementStatus(String status);
}
