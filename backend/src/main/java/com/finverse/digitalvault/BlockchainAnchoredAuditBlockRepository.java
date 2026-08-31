package com.finverse.digitalvault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BlockchainAnchoredAuditBlock
 */
@Repository
public interface BlockchainAnchoredAuditBlockRepository extends JpaRepository<BlockchainAnchoredAuditBlock, UUID> {

    List<BlockchainAnchoredAuditBlock> findByTenantId(UUID tenantId);

    List<BlockchainAnchoredAuditBlock> findByUserId(UUID userId);

    Optional<BlockchainAnchoredAuditBlock> findBySystemReference(String ref);

    List<BlockchainAnchoredAuditBlock> findByOperationalStatus(String status);

    @Query("SELECT e FROM BlockchainAnchoredAuditBlock e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BlockchainAnchoredAuditBlock> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
