package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LiquidityProviderAggregatorRepository extends JpaRepository<LiquidityProviderAggregator, UUID> {
    List<LiquidityProviderAggregator> findByUserId(UUID userId);
    Optional<LiquidityProviderAggregator> findBySettlementRef(String ref);
    List<LiquidityProviderAggregator> findByLifecycleStatus(String status);
}
