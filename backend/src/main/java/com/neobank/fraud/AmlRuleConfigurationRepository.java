package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AmlRuleConfigurationRepository extends JpaRepository<AmlRuleConfiguration, UUID> {
    List<AmlRuleConfiguration> findByUserId(UUID userId);
    Optional<AmlRuleConfiguration> findByRecordKey(String recordKey);
    List<AmlRuleConfiguration> findByStatus(String status);
}
