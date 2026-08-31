package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateCardPolicyRuleRepository extends JpaRepository<CorporateCardPolicyRule, UUID> {
    List<CorporateCardPolicyRule> findByUserId(UUID userId);
    Optional<CorporateCardPolicyRule> findByTrackingCode(String code);
    List<CorporateCardPolicyRule> findByStateFlag(String stateFlag);
}
