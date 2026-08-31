package com.finverse.custody;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DividendReinvestmentPlan
 */
@Repository
public interface DividendReinvestmentPlanRepository extends JpaRepository<DividendReinvestmentPlan, UUID> {

    List<DividendReinvestmentPlan> findByTenantId(UUID tenantId);

    List<DividendReinvestmentPlan> findByUserId(UUID userId);

    Optional<DividendReinvestmentPlan> findBySystemReference(String ref);

    List<DividendReinvestmentPlan> findByOperationalStatus(String status);

    @Query("SELECT e FROM DividendReinvestmentPlan e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DividendReinvestmentPlan> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
