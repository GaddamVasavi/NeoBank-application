package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SuspiciousMonitoringRuleRepository extends JpaRepository<SuspiciousMonitoringRule, UUID> {
    List<SuspiciousMonitoringRule> findByUserId(UUID userId);
    Optional<SuspiciousMonitoringRule> findByIdentifierCode(String code);
    List<SuspiciousMonitoringRule> findByStatus(String status);
}
