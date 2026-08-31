package com.finverse.reporting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DailyFinancialSummaryReport
 */
@Repository
public interface DailyFinancialSummaryReportRepository extends JpaRepository<DailyFinancialSummaryReport, UUID> {

    List<DailyFinancialSummaryReport> findByTenantId(UUID tenantId);

    List<DailyFinancialSummaryReport> findByUserId(UUID userId);

    Optional<DailyFinancialSummaryReport> findBySystemReference(String ref);

    List<DailyFinancialSummaryReport> findByOperationalStatus(String status);

    @Query("SELECT e FROM DailyFinancialSummaryReport e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DailyFinancialSummaryReport> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
