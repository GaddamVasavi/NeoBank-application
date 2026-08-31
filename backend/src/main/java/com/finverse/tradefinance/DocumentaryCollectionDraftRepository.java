package com.finverse.tradefinance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DocumentaryCollectionDraft
 */
@Repository
public interface DocumentaryCollectionDraftRepository extends JpaRepository<DocumentaryCollectionDraft, UUID> {

    List<DocumentaryCollectionDraft> findByTenantId(UUID tenantId);

    List<DocumentaryCollectionDraft> findByUserId(UUID userId);

    Optional<DocumentaryCollectionDraft> findBySystemReference(String ref);

    List<DocumentaryCollectionDraft> findByOperationalStatus(String status);

    @Query("SELECT e FROM DocumentaryCollectionDraft e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DocumentaryCollectionDraft> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
