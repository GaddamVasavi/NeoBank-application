package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RecurringScheduledTransfer
 */
public interface RecurringScheduledTransferService {

    List<RecurringScheduledTransferDto> getByTenant(UUID tenantId);

    List<RecurringScheduledTransferDto> getByUser(UUID userId);

    RecurringScheduledTransferDto create(RecurringScheduledTransferDto dto);

    RecurringScheduledTransferDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RecurringScheduledTransferDto> listAll();
}
