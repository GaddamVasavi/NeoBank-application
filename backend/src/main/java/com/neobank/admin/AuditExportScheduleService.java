package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface AuditExportScheduleService {
    List<AuditExportScheduleDto> getByUser(UUID userId);
    AuditExportScheduleDto create(AuditExportScheduleDto dto);
    AuditExportScheduleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AuditExportScheduleDto> listAll();
}
