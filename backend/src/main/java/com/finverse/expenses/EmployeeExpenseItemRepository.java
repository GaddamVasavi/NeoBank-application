package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EmployeeExpenseItem
 */
@Repository
public interface EmployeeExpenseItemRepository extends JpaRepository<EmployeeExpenseItem, UUID> {

    List<EmployeeExpenseItem> findByTenantId(UUID tenantId);

    List<EmployeeExpenseItem> findByUserId(UUID userId);

    Optional<EmployeeExpenseItem> findBySystemReference(String ref);

    List<EmployeeExpenseItem> findByOperationalStatus(String status);

    @Query("SELECT e FROM EmployeeExpenseItem e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EmployeeExpenseItem> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
