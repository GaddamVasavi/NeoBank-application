package com.finverse.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CashFlowForecastModel
 */
@Repository
public interface CashFlowForecastModelRepository extends JpaRepository<CashFlowForecastModel, UUID> {

    List<CashFlowForecastModel> findByTenantId(UUID tenantId);

    List<CashFlowForecastModel> findByUserId(UUID userId);

    Optional<CashFlowForecastModel> findBySystemReference(String ref);

    List<CashFlowForecastModel> findByOperationalStatus(String status);

    @Query("SELECT e FROM CashFlowForecastModel e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CashFlowForecastModel> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
