package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CommodityTradeFinanceDealRepository extends JpaRepository<CommodityTradeFinanceDeal, UUID> {
    List<CommodityTradeFinanceDeal> findByUserId(UUID userId);
    Optional<CommodityTradeFinanceDeal> findBySettlementRef(String ref);
    List<CommodityTradeFinanceDeal> findByLifecycleStatus(String status);
}
