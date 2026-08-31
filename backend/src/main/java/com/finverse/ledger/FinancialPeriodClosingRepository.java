package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FinancialPeriodClosing
 */
@Repository
public interface FinancialPeriodClosingRepository extends JpaRepository<FinancialPeriodClosing, UUID> {

    List<FinancialPeriodClosing> findByTenantId(UUID tenantId);

    List<FinancialPeriodClosing> findByUserId(UUID userId);

    Optional<FinancialPeriodClosing> findBySystemReference(String ref);

    List<FinancialPeriodClosing> findByOperationalStatus(String status);

    @Query("SELECT e FROM FinancialPeriodClosing e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FinancialPeriodClosing> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
