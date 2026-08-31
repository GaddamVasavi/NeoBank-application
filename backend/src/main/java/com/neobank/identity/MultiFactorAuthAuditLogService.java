package com.neobank.identity;
import java.util.List; import java.util.UUID;
public interface MultiFactorAuthAuditLogService {
    List<MultiFactorAuthAuditLogDto> getByUser(UUID userId);
    MultiFactorAuthAuditLogDto create(MultiFactorAuthAuditLogDto dto);
    MultiFactorAuthAuditLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<MultiFactorAuthAuditLogDto> listAll();
}
