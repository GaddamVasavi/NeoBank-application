package com.neobank.paymentsgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardBrandRoutingRuleConfigRepository extends JpaRepository<CardBrandRoutingRuleConfig, UUID> {
    List<CardBrandRoutingRuleConfig> findByUserId(UUID userId);
    Optional<CardBrandRoutingRuleConfig> findBySystemIdentifier(String id);
    List<CardBrandRoutingRuleConfig> findByValidationState(String state);
}
