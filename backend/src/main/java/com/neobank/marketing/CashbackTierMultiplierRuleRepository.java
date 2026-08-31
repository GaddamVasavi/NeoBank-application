package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CashbackTierMultiplierRuleRepository extends JpaRepository<CashbackTierMultiplierRule, UUID> {
    List<CashbackTierMultiplierRule> findByUserId(UUID userId);
    Optional<CashbackTierMultiplierRule> findByTrackingCode(String code);
    List<CashbackTierMultiplierRule> findByStateFlag(String stateFlag);
}
