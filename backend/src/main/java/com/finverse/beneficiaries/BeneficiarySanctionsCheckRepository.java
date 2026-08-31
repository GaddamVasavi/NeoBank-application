package com.finverse.beneficiaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BeneficiarySanctionsCheck
 */
@Repository
public interface BeneficiarySanctionsCheckRepository extends JpaRepository<BeneficiarySanctionsCheck, UUID> {

    List<BeneficiarySanctionsCheck> findByTenantId(UUID tenantId);

    List<BeneficiarySanctionsCheck> findByUserId(UUID userId);

    Optional<BeneficiarySanctionsCheck> findBySystemReference(String ref);

    List<BeneficiarySanctionsCheck> findByOperationalStatus(String status);

    @Query("SELECT e FROM BeneficiarySanctionsCheck e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BeneficiarySanctionsCheck> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
