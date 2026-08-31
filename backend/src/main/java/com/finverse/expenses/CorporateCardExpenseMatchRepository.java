package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CorporateCardExpenseMatch
 */
@Repository
public interface CorporateCardExpenseMatchRepository extends JpaRepository<CorporateCardExpenseMatch, UUID> {

    List<CorporateCardExpenseMatch> findByTenantId(UUID tenantId);

    List<CorporateCardExpenseMatch> findByUserId(UUID userId);

    Optional<CorporateCardExpenseMatch> findBySystemReference(String ref);

    List<CorporateCardExpenseMatch> findByOperationalStatus(String status);

    @Query("SELECT e FROM CorporateCardExpenseMatch e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CorporateCardExpenseMatch> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
