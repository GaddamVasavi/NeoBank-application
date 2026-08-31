package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface ComplianceEnforcementActionService {
    List<ComplianceEnforcementActionDto> getByUser(UUID userId);
    ComplianceEnforcementActionDto create(ComplianceEnforcementActionDto dto);
    ComplianceEnforcementActionDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<ComplianceEnforcementActionDto> listAll();
}
