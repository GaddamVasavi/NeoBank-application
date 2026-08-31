package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InvoiceHeaderMaster
 */
public interface InvoiceHeaderMasterService {

    List<InvoiceHeaderMasterDto> getByTenant(UUID tenantId);

    List<InvoiceHeaderMasterDto> getByUser(UUID userId);

    InvoiceHeaderMasterDto create(InvoiceHeaderMasterDto dto);

    InvoiceHeaderMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InvoiceHeaderMasterDto> listAll();
}
