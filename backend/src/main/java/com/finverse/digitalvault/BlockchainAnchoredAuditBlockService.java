package com.finverse.digitalvault;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BlockchainAnchoredAuditBlock
 */
public interface BlockchainAnchoredAuditBlockService {

    List<BlockchainAnchoredAuditBlockDto> getByTenant(UUID tenantId);

    List<BlockchainAnchoredAuditBlockDto> getByUser(UUID userId);

    BlockchainAnchoredAuditBlockDto create(BlockchainAnchoredAuditBlockDto dto);

    BlockchainAnchoredAuditBlockDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BlockchainAnchoredAuditBlockDto> listAll();
}
