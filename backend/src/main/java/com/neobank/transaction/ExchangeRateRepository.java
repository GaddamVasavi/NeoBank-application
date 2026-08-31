package com.neobank.transaction;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.Optional; import java.util.UUID;
@Repository public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, UUID> {
    Optional<ExchangeRate> findTopBySourceCurrencyAndTargetCurrencyOrderByEffectiveAtDesc(String src, String target);
}
