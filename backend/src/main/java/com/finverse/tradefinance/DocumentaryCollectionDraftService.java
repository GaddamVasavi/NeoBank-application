package com.finverse.tradefinance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DocumentaryCollectionDraft
 */
public interface DocumentaryCollectionDraftService {

    List<DocumentaryCollectionDraftDto> getByTenant(UUID tenantId);

    List<DocumentaryCollectionDraftDto> getByUser(UUID userId);

    DocumentaryCollectionDraftDto create(DocumentaryCollectionDraftDto dto);

    DocumentaryCollectionDraftDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DocumentaryCollectionDraftDto> listAll();
}
