package com.neobank.auditstream;
import java.util.List; import java.util.UUID;
public interface ImmutableAuditLogBlockService {
    List<ImmutableAuditLogBlockDto> getByUser(UUID userId);
    ImmutableAuditLogBlockDto create(ImmutableAuditLogBlockDto dto);
    ImmutableAuditLogBlockDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ImmutableAuditLogBlockDto> listAll();
}
