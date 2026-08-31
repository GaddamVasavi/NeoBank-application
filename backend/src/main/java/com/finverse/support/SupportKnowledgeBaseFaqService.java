package com.finverse.support;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SupportKnowledgeBaseFaq
 */
public interface SupportKnowledgeBaseFaqService {

    List<SupportKnowledgeBaseFaqDto> getByTenant(UUID tenantId);

    List<SupportKnowledgeBaseFaqDto> getByUser(UUID userId);

    SupportKnowledgeBaseFaqDto create(SupportKnowledgeBaseFaqDto dto);

    SupportKnowledgeBaseFaqDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SupportKnowledgeBaseFaqDto> listAll();
}
