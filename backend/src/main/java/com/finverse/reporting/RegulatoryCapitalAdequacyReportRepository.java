package com.finverse.reporting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RegulatoryCapitalAdequacyReport
 */
@Repository
public interface RegulatoryCapitalAdequacyReportRepository extends JpaRepository<RegulatoryCapitalAdequacyReport, UUID> {

    List<RegulatoryCapitalAdequacyReport> findByTenantId(UUID tenantId);

    List<RegulatoryCapitalAdequacyReport> findByUserId(UUID userId);

    Optional<RegulatoryCapitalAdequacyReport> findBySystemReference(String ref);

    List<RegulatoryCapitalAdequacyReport> findByOperationalStatus(String status);

    @Query("SELECT e FROM RegulatoryCapitalAdequacyReport e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RegulatoryCapitalAdequacyReport> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
