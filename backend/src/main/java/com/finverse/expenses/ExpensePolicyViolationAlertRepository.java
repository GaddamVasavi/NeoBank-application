package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ExpensePolicyViolationAlert
 */
@Repository
public interface ExpensePolicyViolationAlertRepository extends JpaRepository<ExpensePolicyViolationAlert, UUID> {

    List<ExpensePolicyViolationAlert> findByTenantId(UUID tenantId);

    List<ExpensePolicyViolationAlert> findByUserId(UUID userId);

    Optional<ExpensePolicyViolationAlert> findBySystemReference(String ref);

    List<ExpensePolicyViolationAlert> findByOperationalStatus(String status);

    @Query("SELECT e FROM ExpensePolicyViolationAlert e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ExpensePolicyViolationAlert> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
