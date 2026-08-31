package com.finverse.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for NetInterestMarginAnalytics
 */
@Repository
public interface NetInterestMarginAnalyticsRepository extends JpaRepository<NetInterestMarginAnalytics, UUID> {

    List<NetInterestMarginAnalytics> findByTenantId(UUID tenantId);

    List<NetInterestMarginAnalytics> findByUserId(UUID userId);

    Optional<NetInterestMarginAnalytics> findBySystemReference(String ref);

    List<NetInterestMarginAnalytics> findByOperationalStatus(String status);

    @Query("SELECT e FROM NetInterestMarginAnalytics e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<NetInterestMarginAnalytics> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
