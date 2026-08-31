package com.neobank.derivatives;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CommodityFutureContractDealRepository extends JpaRepository<CommodityFutureContractDeal, UUID> {
    List<CommodityFutureContractDeal> findByUserId(UUID userId);
    Optional<CommodityFutureContractDeal> findByClearingKey(String key);
    List<CommodityFutureContractDeal> findByAuditStatus(String status);
}
