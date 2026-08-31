package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ExpenseApprovalHierarchy
 */
@Repository
public interface ExpenseApprovalHierarchyRepository extends JpaRepository<ExpenseApprovalHierarchy, UUID> {

    List<ExpenseApprovalHierarchy> findByTenantId(UUID tenantId);

    List<ExpenseApprovalHierarchy> findByUserId(UUID userId);

    Optional<ExpenseApprovalHierarchy> findBySystemReference(String ref);

    List<ExpenseApprovalHierarchy> findByOperationalStatus(String status);

    @Query("SELECT e FROM ExpenseApprovalHierarchy e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ExpenseApprovalHierarchy> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
