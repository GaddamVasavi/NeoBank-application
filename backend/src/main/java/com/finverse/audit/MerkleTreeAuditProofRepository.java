package com.finverse.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for MerkleTreeAuditProof
 */
@Repository
public interface MerkleTreeAuditProofRepository extends JpaRepository<MerkleTreeAuditProof, UUID> {

    List<MerkleTreeAuditProof> findByTenantId(UUID tenantId);

    List<MerkleTreeAuditProof> findByUserId(UUID userId);

    Optional<MerkleTreeAuditProof> findBySystemReference(String ref);

    List<MerkleTreeAuditProof> findByOperationalStatus(String status);

    @Query("SELECT e FROM MerkleTreeAuditProof e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<MerkleTreeAuditProof> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
