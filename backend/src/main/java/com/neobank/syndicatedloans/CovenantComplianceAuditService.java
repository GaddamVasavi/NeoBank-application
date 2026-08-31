package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface CovenantComplianceAuditService {
    List<CovenantComplianceAuditDto> getByUser(UUID userId);
    CovenantComplianceAuditDto create(CovenantComplianceAuditDto dto);
    CovenantComplianceAuditDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CovenantComplianceAuditDto> listAll();
}
