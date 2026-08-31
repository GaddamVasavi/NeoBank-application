package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ExpenseCategoryTaxMapping
 */
@Repository
public interface ExpenseCategoryTaxMappingRepository extends JpaRepository<ExpenseCategoryTaxMapping, UUID> {

    List<ExpenseCategoryTaxMapping> findByTenantId(UUID tenantId);

    List<ExpenseCategoryTaxMapping> findByUserId(UUID userId);

    Optional<ExpenseCategoryTaxMapping> findBySystemReference(String ref);

    List<ExpenseCategoryTaxMapping> findByOperationalStatus(String status);

    @Query("SELECT e FROM ExpenseCategoryTaxMapping e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ExpenseCategoryTaxMapping> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
