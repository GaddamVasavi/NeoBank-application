package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface AgentAssignmentRuleService {
    List<AgentAssignmentRuleDto> getByUser(UUID userId);
    AgentAssignmentRuleDto create(AgentAssignmentRuleDto dto);
    AgentAssignmentRuleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AgentAssignmentRuleDto> listAll();
}
