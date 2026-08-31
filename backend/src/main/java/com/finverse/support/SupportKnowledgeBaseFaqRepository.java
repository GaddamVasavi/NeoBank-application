package com.finverse.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SupportKnowledgeBaseFaq
 */
@Repository
public interface SupportKnowledgeBaseFaqRepository extends JpaRepository<SupportKnowledgeBaseFaq, UUID> {

    List<SupportKnowledgeBaseFaq> findByTenantId(UUID tenantId);

    List<SupportKnowledgeBaseFaq> findByUserId(UUID userId);

    Optional<SupportKnowledgeBaseFaq> findBySystemReference(String ref);

    List<SupportKnowledgeBaseFaq> findByOperationalStatus(String status);

    @Query("SELECT e FROM SupportKnowledgeBaseFaq e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SupportKnowledgeBaseFaq> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
