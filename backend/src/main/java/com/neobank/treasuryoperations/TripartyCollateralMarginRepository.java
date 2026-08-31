package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TripartyCollateralMarginRepository extends JpaRepository<TripartyCollateralMargin, UUID> {
    List<TripartyCollateralMargin> findByUserId(UUID userId);
    Optional<TripartyCollateralMargin> findByClearingIdentifier(String id);
    List<TripartyCollateralMargin> findBySettlementStatus(String status);
}
