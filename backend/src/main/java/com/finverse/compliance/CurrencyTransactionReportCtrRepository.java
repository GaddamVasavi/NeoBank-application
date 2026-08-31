package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CurrencyTransactionReportCtr
 */
@Repository
public interface CurrencyTransactionReportCtrRepository extends JpaRepository<CurrencyTransactionReportCtr, UUID> {

    List<CurrencyTransactionReportCtr> findByTenantId(UUID tenantId);

    List<CurrencyTransactionReportCtr> findByUserId(UUID userId);

    Optional<CurrencyTransactionReportCtr> findBySystemReference(String ref);

    List<CurrencyTransactionReportCtr> findByOperationalStatus(String status);

    @Query("SELECT e FROM CurrencyTransactionReportCtr e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CurrencyTransactionReportCtr> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
