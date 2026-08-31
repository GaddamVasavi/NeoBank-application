package com.finverse.carboncredits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for Scope3FinancedEmissions
 */
@Repository
public interface Scope3FinancedEmissionsRepository extends JpaRepository<Scope3FinancedEmissions, UUID> {

    List<Scope3FinancedEmissions> findByTenantId(UUID tenantId);

    List<Scope3FinancedEmissions> findByUserId(UUID userId);

    Optional<Scope3FinancedEmissions> findBySystemReference(String ref);

    List<Scope3FinancedEmissions> findByOperationalStatus(String status);

    @Query("SELECT e FROM Scope3FinancedEmissions e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<Scope3FinancedEmissions> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
