package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CrossCurrencyBasisSwapRepository extends JpaRepository<CrossCurrencyBasisSwap, UUID> {
    List<CrossCurrencyBasisSwap> findByUserId(UUID userId);
    Optional<CrossCurrencyBasisSwap> findBySettlementRef(String ref);
    List<CrossCurrencyBasisSwap> findByLifecycleStatus(String status);
}
