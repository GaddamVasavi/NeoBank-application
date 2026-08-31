package com.finverse.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PlatformTelemetryMetrics
 */
@Repository
public interface PlatformTelemetryMetricsRepository extends JpaRepository<PlatformTelemetryMetrics, UUID> {

    List<PlatformTelemetryMetrics> findByTenantId(UUID tenantId);

    List<PlatformTelemetryMetrics> findByUserId(UUID userId);

    Optional<PlatformTelemetryMetrics> findBySystemReference(String ref);

    List<PlatformTelemetryMetrics> findByOperationalStatus(String status);

    @Query("SELECT e FROM PlatformTelemetryMetrics e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PlatformTelemetryMetrics> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
