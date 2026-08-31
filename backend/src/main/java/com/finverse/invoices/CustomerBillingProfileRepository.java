package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CustomerBillingProfile
 */
@Repository
public interface CustomerBillingProfileRepository extends JpaRepository<CustomerBillingProfile, UUID> {

    List<CustomerBillingProfile> findByTenantId(UUID tenantId);

    List<CustomerBillingProfile> findByUserId(UUID userId);

    Optional<CustomerBillingProfile> findBySystemReference(String ref);

    List<CustomerBillingProfile> findByOperationalStatus(String status);

    @Query("SELECT e FROM CustomerBillingProfile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CustomerBillingProfile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
