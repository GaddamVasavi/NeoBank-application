package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DataRetentionPolicyRuleRepository extends JpaRepository<DataRetentionPolicyRule, UUID> {
    List<DataRetentionPolicyRule> findByUserId(UUID userId);
    Optional<DataRetentionPolicyRule> findByIdentifierCode(String code);
    List<DataRetentionPolicyRule> findByStatus(String status);
}
