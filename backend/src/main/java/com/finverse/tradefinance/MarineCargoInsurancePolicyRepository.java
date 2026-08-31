package com.finverse.tradefinance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for MarineCargoInsurancePolicy
 */
@Repository
public interface MarineCargoInsurancePolicyRepository extends JpaRepository<MarineCargoInsurancePolicy, UUID> {

    List<MarineCargoInsurancePolicy> findByTenantId(UUID tenantId);

    List<MarineCargoInsurancePolicy> findByUserId(UUID userId);

    Optional<MarineCargoInsurancePolicy> findBySystemReference(String ref);

    List<MarineCargoInsurancePolicy> findByOperationalStatus(String status);

    @Query("SELECT e FROM MarineCargoInsurancePolicy e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<MarineCargoInsurancePolicy> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
