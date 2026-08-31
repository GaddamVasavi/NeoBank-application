package com.finverse.custody;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CorporateActionProxyVote
 */
@Repository
public interface CorporateActionProxyVoteRepository extends JpaRepository<CorporateActionProxyVote, UUID> {

    List<CorporateActionProxyVote> findByTenantId(UUID tenantId);

    List<CorporateActionProxyVote> findByUserId(UUID userId);

    Optional<CorporateActionProxyVote> findBySystemReference(String ref);

    List<CorporateActionProxyVote> findByOperationalStatus(String status);

    @Query("SELECT e FROM CorporateActionProxyVote e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CorporateActionProxyVote> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
