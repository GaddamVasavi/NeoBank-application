package com.neobank.auditstream;
import java.util.List; import java.util.UUID;
public interface ComplianceInspectorSessionService {
    List<ComplianceInspectorSessionDto> getByUser(UUID userId);
    ComplianceInspectorSessionDto create(ComplianceInspectorSessionDto dto);
    ComplianceInspectorSessionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ComplianceInspectorSessionDto> listAll();
}
