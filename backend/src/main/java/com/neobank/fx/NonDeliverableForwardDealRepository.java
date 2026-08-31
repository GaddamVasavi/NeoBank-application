package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NonDeliverableForwardDealRepository extends JpaRepository<NonDeliverableForwardDeal, UUID> {
    List<NonDeliverableForwardDeal> findByUserId(UUID userId);
    Optional<NonDeliverableForwardDeal> findBySettlementRef(String ref);
    List<NonDeliverableForwardDeal> findByLifecycleStatus(String status);
}
