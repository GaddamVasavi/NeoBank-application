package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for LoanRepaymentInstallment
 */
@Repository
public interface LoanRepaymentInstallmentRepository extends JpaRepository<LoanRepaymentInstallment, UUID> {

    List<LoanRepaymentInstallment> findByTenantId(UUID tenantId);

    List<LoanRepaymentInstallment> findByUserId(UUID userId);

    Optional<LoanRepaymentInstallment> findBySystemReference(String ref);

    List<LoanRepaymentInstallment> findByOperationalStatus(String status);

    @Query("SELECT e FROM LoanRepaymentInstallment e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<LoanRepaymentInstallment> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
