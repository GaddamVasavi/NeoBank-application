package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EarlyLoanRepaymentSettlement
 */
@Repository
public interface EarlyLoanRepaymentSettlementRepository extends JpaRepository<EarlyLoanRepaymentSettlement, UUID> {

    List<EarlyLoanRepaymentSettlement> findByTenantId(UUID tenantId);

    List<EarlyLoanRepaymentSettlement> findByUserId(UUID userId);

    Optional<EarlyLoanRepaymentSettlement> findBySystemReference(String ref);

    List<EarlyLoanRepaymentSettlement> findByOperationalStatus(String status);

    @Query("SELECT e FROM EarlyLoanRepaymentSettlement e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EarlyLoanRepaymentSettlement> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
