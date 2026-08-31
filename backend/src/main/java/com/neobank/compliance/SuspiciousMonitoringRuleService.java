package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface SuspiciousMonitoringRuleService {
    List<SuspiciousMonitoringRuleDto> getByUser(UUID userId);
    SuspiciousMonitoringRuleDto create(SuspiciousMonitoringRuleDto dto);
    SuspiciousMonitoringRuleDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<SuspiciousMonitoringRuleDto> listAll();
}
