package com.neobank.paymentsgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SurchargeFeeRuleConfigRepository extends JpaRepository<SurchargeFeeRuleConfig, UUID> {
    List<SurchargeFeeRuleConfig> findByUserId(UUID userId);
    Optional<SurchargeFeeRuleConfig> findBySystemIdentifier(String id);
    List<SurchargeFeeRuleConfig> findByValidationState(String state);
}
