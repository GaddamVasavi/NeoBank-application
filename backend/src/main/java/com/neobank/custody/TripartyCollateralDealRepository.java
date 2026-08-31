package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TripartyCollateralDealRepository extends JpaRepository<TripartyCollateralDeal, UUID> {
    List<TripartyCollateralDeal> findByUserId(UUID userId);
    Optional<TripartyCollateralDeal> findBySettlementRef(String ref);
    List<TripartyCollateralDeal> findByLifecycleStatus(String status);
}
