package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TaxJurisdictionRate
 */
@Repository
public interface TaxJurisdictionRateRepository extends JpaRepository<TaxJurisdictionRate, UUID> {

    List<TaxJurisdictionRate> findByTenantId(UUID tenantId);

    List<TaxJurisdictionRate> findByUserId(UUID userId);

    Optional<TaxJurisdictionRate> findBySystemReference(String ref);

    List<TaxJurisdictionRate> findByOperationalStatus(String status);

    @Query("SELECT e FROM TaxJurisdictionRate e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TaxJurisdictionRate> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
