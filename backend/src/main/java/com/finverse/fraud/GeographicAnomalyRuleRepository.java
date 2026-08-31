package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for GeographicAnomalyRule
 */
@Repository
public interface GeographicAnomalyRuleRepository extends JpaRepository<GeographicAnomalyRule, UUID> {

    List<GeographicAnomalyRule> findByTenantId(UUID tenantId);

    List<GeographicAnomalyRule> findByUserId(UUID userId);

    Optional<GeographicAnomalyRule> findBySystemReference(String ref);

    List<GeographicAnomalyRule> findByOperationalStatus(String status);

    @Query("SELECT e FROM GeographicAnomalyRule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<GeographicAnomalyRule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
