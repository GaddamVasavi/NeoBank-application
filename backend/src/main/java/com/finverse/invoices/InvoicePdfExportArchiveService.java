package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InvoicePdfExportArchive
 */
public interface InvoicePdfExportArchiveService {

    List<InvoicePdfExportArchiveDto> getByTenant(UUID tenantId);

    List<InvoicePdfExportArchiveDto> getByUser(UUID userId);

    InvoicePdfExportArchiveDto create(InvoicePdfExportArchiveDto dto);

    InvoicePdfExportArchiveDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InvoicePdfExportArchiveDto> listAll();
}
