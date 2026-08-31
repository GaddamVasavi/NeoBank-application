package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface SftpFileTransferAuditLogService {
    List<SftpFileTransferAuditLogDto> getByUser(UUID userId);
    SftpFileTransferAuditLogDto create(SftpFileTransferAuditLogDto dto);
    SftpFileTransferAuditLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SftpFileTransferAuditLogDto> listAll();
}
