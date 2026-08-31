package com.finverse.reporting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TaxWithholdingSummaryReport
 */
@Repository
public interface TaxWithholdingSummaryReportRepository extends JpaRepository<TaxWithholdingSummaryReport, UUID> {

    List<TaxWithholdingSummaryReport> findByTenantId(UUID tenantId);

    List<TaxWithholdingSummaryReport> findByUserId(UUID userId);

    Optional<TaxWithholdingSummaryReport> findBySystemReference(String ref);

    List<TaxWithholdingSummaryReport> findByOperationalStatus(String status);

    @Query("SELECT e FROM TaxWithholdingSummaryReport e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TaxWithholdingSummaryReport> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
