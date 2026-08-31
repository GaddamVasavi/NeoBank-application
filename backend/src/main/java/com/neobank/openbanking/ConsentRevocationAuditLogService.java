package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface ConsentRevocationAuditLogService {
    List<ConsentRevocationAuditLogDto> getByUser(UUID userId);
    ConsentRevocationAuditLogDto create(ConsentRevocationAuditLogDto dto);
    ConsentRevocationAuditLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ConsentRevocationAuditLogDto> listAll();
}
