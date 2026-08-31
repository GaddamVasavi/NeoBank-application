package com.finverse.digitalvault;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ZeroKnowledgeProofSolvency
 */
public interface ZeroKnowledgeProofSolvencyService {

    List<ZeroKnowledgeProofSolvencyDto> getByTenant(UUID tenantId);

    List<ZeroKnowledgeProofSolvencyDto> getByUser(UUID userId);

    ZeroKnowledgeProofSolvencyDto create(ZeroKnowledgeProofSolvencyDto dto);

    ZeroKnowledgeProofSolvencyDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ZeroKnowledgeProofSolvencyDto> listAll();
}
