package com.finverse.audit;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MerkleTreeAuditProof
 */
public interface MerkleTreeAuditProofService {

    List<MerkleTreeAuditProofDto> getByTenant(UUID tenantId);

    List<MerkleTreeAuditProofDto> getByUser(UUID userId);

    MerkleTreeAuditProofDto create(MerkleTreeAuditProofDto dto);

    MerkleTreeAuditProofDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MerkleTreeAuditProofDto> listAll();
}
