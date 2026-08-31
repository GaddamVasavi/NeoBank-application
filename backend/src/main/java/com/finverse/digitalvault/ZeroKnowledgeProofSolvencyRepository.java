package com.finverse.digitalvault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ZeroKnowledgeProofSolvency
 */
@Repository
public interface ZeroKnowledgeProofSolvencyRepository extends JpaRepository<ZeroKnowledgeProofSolvency, UUID> {

    List<ZeroKnowledgeProofSolvency> findByTenantId(UUID tenantId);

    List<ZeroKnowledgeProofSolvency> findByUserId(UUID userId);

    Optional<ZeroKnowledgeProofSolvency> findBySystemReference(String ref);

    List<ZeroKnowledgeProofSolvency> findByOperationalStatus(String status);

    @Query("SELECT e FROM ZeroKnowledgeProofSolvency e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ZeroKnowledgeProofSolvency> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
