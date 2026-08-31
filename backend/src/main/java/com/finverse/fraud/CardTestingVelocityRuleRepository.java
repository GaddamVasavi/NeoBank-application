package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardTestingVelocityRule
 */
@Repository
public interface CardTestingVelocityRuleRepository extends JpaRepository<CardTestingVelocityRule, UUID> {

    List<CardTestingVelocityRule> findByTenantId(UUID tenantId);

    List<CardTestingVelocityRule> findByUserId(UUID userId);

    Optional<CardTestingVelocityRule> findBySystemReference(String ref);

    List<CardTestingVelocityRule> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardTestingVelocityRule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardTestingVelocityRule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
