package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CurrencyOptionContractRepository extends JpaRepository<CurrencyOptionContract, UUID> {
    List<CurrencyOptionContract> findByUserId(UUID userId);
    Optional<CurrencyOptionContract> findBySettlementRef(String ref);
    List<CurrencyOptionContract> findByLifecycleStatus(String status);
}
