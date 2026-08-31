package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface DisasterRecoveryAuditLogService {
    List<DisasterRecoveryAuditLogDto> getByUser(UUID userId);
    DisasterRecoveryAuditLogDto create(DisasterRecoveryAuditLogDto dto);
    DisasterRecoveryAuditLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<DisasterRecoveryAuditLogDto> listAll();
}
