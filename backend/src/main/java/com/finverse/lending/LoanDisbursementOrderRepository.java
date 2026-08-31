package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for LoanDisbursementOrder
 */
@Repository
public interface LoanDisbursementOrderRepository extends JpaRepository<LoanDisbursementOrder, UUID> {

    List<LoanDisbursementOrder> findByTenantId(UUID tenantId);

    List<LoanDisbursementOrder> findByUserId(UUID userId);

    Optional<LoanDisbursementOrder> findBySystemReference(String ref);

    List<LoanDisbursementOrder> findByOperationalStatus(String status);

    @Query("SELECT e FROM LoanDisbursementOrder e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<LoanDisbursementOrder> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
