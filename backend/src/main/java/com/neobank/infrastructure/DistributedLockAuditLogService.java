package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface DistributedLockAuditLogService {
    List<DistributedLockAuditLogDto> getByUser(UUID userId);
    DistributedLockAuditLogDto create(DistributedLockAuditLogDto dto);
    DistributedLockAuditLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DistributedLockAuditLogDto> listAll();
}
