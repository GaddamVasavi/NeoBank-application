package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RecurringInvoiceProfile
 */
public interface RecurringInvoiceProfileService {

    List<RecurringInvoiceProfileDto> getByTenant(UUID tenantId);

    List<RecurringInvoiceProfileDto> getByUser(UUID userId);

    RecurringInvoiceProfileDto create(RecurringInvoiceProfileDto dto);

    RecurringInvoiceProfileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RecurringInvoiceProfileDto> listAll();
}
