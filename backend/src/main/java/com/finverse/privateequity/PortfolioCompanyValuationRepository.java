package com.finverse.privateequity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PortfolioCompanyValuation
 */
@Repository
public interface PortfolioCompanyValuationRepository extends JpaRepository<PortfolioCompanyValuation, UUID> {

    List<PortfolioCompanyValuation> findByTenantId(UUID tenantId);

    List<PortfolioCompanyValuation> findByUserId(UUID userId);

    Optional<PortfolioCompanyValuation> findBySystemReference(String ref);

    List<PortfolioCompanyValuation> findByOperationalStatus(String status);

    @Query("SELECT e FROM PortfolioCompanyValuation e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PortfolioCompanyValuation> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
