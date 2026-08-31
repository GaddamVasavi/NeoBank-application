package com.finverse.audit;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ImmutableAuditBlockRecord
 */
public interface ImmutableAuditBlockRecordService {

    List<ImmutableAuditBlockRecordDto> getByTenant(UUID tenantId);

    List<ImmutableAuditBlockRecordDto> getByUser(UUID userId);

    ImmutableAuditBlockRecordDto create(ImmutableAuditBlockRecordDto dto);

    ImmutableAuditBlockRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ImmutableAuditBlockRecordDto> listAll();
}
