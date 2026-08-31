package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface AuditTrailExportArchiveService {
    List<AuditTrailExportArchiveDto> getByUser(UUID userId);
    AuditTrailExportArchiveDto create(AuditTrailExportArchiveDto dto);
    AuditTrailExportArchiveDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<AuditTrailExportArchiveDto> listAll();
}
