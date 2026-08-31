package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InvoiceLineItemRecord
 */
public interface InvoiceLineItemRecordService {

    List<InvoiceLineItemRecordDto> getByTenant(UUID tenantId);

    List<InvoiceLineItemRecordDto> getByUser(UUID userId);

    InvoiceLineItemRecordDto create(InvoiceLineItemRecordDto dto);

    InvoiceLineItemRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InvoiceLineItemRecordDto> listAll();
}
