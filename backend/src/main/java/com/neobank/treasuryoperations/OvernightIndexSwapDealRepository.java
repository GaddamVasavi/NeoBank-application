package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OvernightIndexSwapDealRepository extends JpaRepository<OvernightIndexSwapDeal, UUID> {
    List<OvernightIndexSwapDeal> findByUserId(UUID userId);
    Optional<OvernightIndexSwapDeal> findByClearingIdentifier(String id);
    List<OvernightIndexSwapDeal> findBySettlementStatus(String status);
}
