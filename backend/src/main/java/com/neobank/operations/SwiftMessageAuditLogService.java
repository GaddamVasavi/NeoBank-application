package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface SwiftMessageAuditLogService {
    List<SwiftMessageAuditLogDto> getByUser(UUID userId);
    SwiftMessageAuditLogDto create(SwiftMessageAuditLogDto dto);
    SwiftMessageAuditLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<SwiftMessageAuditLogDto> listAll();
}
