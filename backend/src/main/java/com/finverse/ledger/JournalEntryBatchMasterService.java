package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for JournalEntryBatchMaster
 */
public interface JournalEntryBatchMasterService {

    List<JournalEntryBatchMasterDto> getByTenant(UUID tenantId);

    List<JournalEntryBatchMasterDto> getByUser(UUID userId);

    JournalEntryBatchMasterDto create(JournalEntryBatchMasterDto dto);

    JournalEntryBatchMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<JournalEntryBatchMasterDto> listAll();
}
