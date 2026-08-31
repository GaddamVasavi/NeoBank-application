package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CreditNoteAdjustment
 */
public interface CreditNoteAdjustmentService {

    List<CreditNoteAdjustmentDto> getByTenant(UUID tenantId);

    List<CreditNoteAdjustmentDto> getByUser(UUID userId);

    CreditNoteAdjustmentDto create(CreditNoteAdjustmentDto dto);

    CreditNoteAdjustmentDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CreditNoteAdjustmentDto> listAll();
}
