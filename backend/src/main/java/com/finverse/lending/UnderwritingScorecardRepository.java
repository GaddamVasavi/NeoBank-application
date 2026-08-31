package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UnderwritingScorecard
 */
@Repository
public interface UnderwritingScorecardRepository extends JpaRepository<UnderwritingScorecard, UUID> {

    List<UnderwritingScorecard> findByTenantId(UUID tenantId);

    List<UnderwritingScorecard> findByUserId(UUID userId);

    Optional<UnderwritingScorecard> findBySystemReference(String ref);

    List<UnderwritingScorecard> findByOperationalStatus(String status);

    @Query("SELECT e FROM UnderwritingScorecard e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UnderwritingScorecard> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
