package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InvoicePaymentAllocation
 */
public interface InvoicePaymentAllocationService {

    List<InvoicePaymentAllocationDto> getByTenant(UUID tenantId);

    List<InvoicePaymentAllocationDto> getByUser(UUID userId);

    InvoicePaymentAllocationDto create(InvoicePaymentAllocationDto dto);

    InvoicePaymentAllocationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InvoicePaymentAllocationDto> listAll();
}
