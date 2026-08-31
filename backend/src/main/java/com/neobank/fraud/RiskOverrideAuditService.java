package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface RiskOverrideAuditService {
    List<RiskOverrideAuditDto> getByUser(UUID userId);
    RiskOverrideAuditDto create(RiskOverrideAuditDto dto);
    RiskOverrideAuditDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RiskOverrideAuditDto> listAll();
}
