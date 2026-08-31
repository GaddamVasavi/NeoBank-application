package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface AuditCommitteeCharterLogService {
    List<AuditCommitteeCharterLogDto> getByUser(UUID userId);
    AuditCommitteeCharterLogDto create(AuditCommitteeCharterLogDto dto);
    AuditCommitteeCharterLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AuditCommitteeCharterLogDto> listAll();
}
