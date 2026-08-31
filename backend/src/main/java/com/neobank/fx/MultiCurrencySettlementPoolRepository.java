package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MultiCurrencySettlementPoolRepository extends JpaRepository<MultiCurrencySettlementPool, UUID> {
    List<MultiCurrencySettlementPool> findByUserId(UUID userId);
    Optional<MultiCurrencySettlementPool> findBySettlementRef(String ref);
    List<MultiCurrencySettlementPool> findByLifecycleStatus(String status);
}
