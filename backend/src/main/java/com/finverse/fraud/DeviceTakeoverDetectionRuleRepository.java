package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DeviceTakeoverDetectionRule
 */
@Repository
public interface DeviceTakeoverDetectionRuleRepository extends JpaRepository<DeviceTakeoverDetectionRule, UUID> {

    List<DeviceTakeoverDetectionRule> findByTenantId(UUID tenantId);

    List<DeviceTakeoverDetectionRule> findByUserId(UUID userId);

    Optional<DeviceTakeoverDetectionRule> findBySystemReference(String ref);

    List<DeviceTakeoverDetectionRule> findByOperationalStatus(String status);

    @Query("SELECT e FROM DeviceTakeoverDetectionRule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DeviceTakeoverDetectionRule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
