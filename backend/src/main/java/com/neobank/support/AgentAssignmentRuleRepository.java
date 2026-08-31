package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AgentAssignmentRuleRepository extends JpaRepository<AgentAssignmentRule, UUID> {
    List<AgentAssignmentRule> findByUserId(UUID userId);
    Optional<AgentAssignmentRule> findByRecordKey(String recordKey);
    List<AgentAssignmentRule> findByStatus(String status);
}
