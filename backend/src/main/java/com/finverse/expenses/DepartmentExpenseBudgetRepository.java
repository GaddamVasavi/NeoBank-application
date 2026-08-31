package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DepartmentExpenseBudget
 */
@Repository
public interface DepartmentExpenseBudgetRepository extends JpaRepository<DepartmentExpenseBudget, UUID> {

    List<DepartmentExpenseBudget> findByTenantId(UUID tenantId);

    List<DepartmentExpenseBudget> findByUserId(UUID userId);

    Optional<DepartmentExpenseBudget> findBySystemReference(String ref);

    List<DepartmentExpenseBudget> findByOperationalStatus(String status);

    @Query("SELECT e FROM DepartmentExpenseBudget e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DepartmentExpenseBudget> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
