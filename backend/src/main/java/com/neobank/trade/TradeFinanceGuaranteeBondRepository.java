package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TradeFinanceGuaranteeBondRepository extends JpaRepository<TradeFinanceGuaranteeBond, UUID> {
    List<TradeFinanceGuaranteeBond> findByUserId(UUID userId);
    Optional<TradeFinanceGuaranteeBond> findBySettlementRef(String ref);
    List<TradeFinanceGuaranteeBond> findByLifecycleStatus(String status);
}
