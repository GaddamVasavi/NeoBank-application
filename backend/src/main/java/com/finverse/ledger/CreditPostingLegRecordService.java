package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CreditPostingLegRecord
 */
public interface CreditPostingLegRecordService {

    List<CreditPostingLegRecordDto> getByTenant(UUID tenantId);

    List<CreditPostingLegRecordDto> getByUser(UUID userId);

    CreditPostingLegRecordDto create(CreditPostingLegRecordDto dto);

    CreditPostingLegRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CreditPostingLegRecordDto> listAll();
}
