package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DebitPostingLegRecord
 */
public interface DebitPostingLegRecordService {

    List<DebitPostingLegRecordDto> getByTenant(UUID tenantId);

    List<DebitPostingLegRecordDto> getByUser(UUID userId);

    DebitPostingLegRecordDto create(DebitPostingLegRecordDto dto);

    DebitPostingLegRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DebitPostingLegRecordDto> listAll();
}
