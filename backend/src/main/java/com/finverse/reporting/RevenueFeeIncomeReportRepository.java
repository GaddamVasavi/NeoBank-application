package com.finverse.reporting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RevenueFeeIncomeReport
 */
@Repository
public interface RevenueFeeIncomeReportRepository extends JpaRepository<RevenueFeeIncomeReport, UUID> {

    List<RevenueFeeIncomeReport> findByTenantId(UUID tenantId);

    List<RevenueFeeIncomeReport> findByUserId(UUID userId);

    Optional<RevenueFeeIncomeReport> findBySystemReference(String ref);

    List<RevenueFeeIncomeReport> findByOperationalStatus(String status);

    @Query("SELECT e FROM RevenueFeeIncomeReport e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RevenueFeeIncomeReport> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
