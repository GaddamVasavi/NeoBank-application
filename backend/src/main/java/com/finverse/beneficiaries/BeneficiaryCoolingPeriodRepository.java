package com.finverse.beneficiaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BeneficiaryCoolingPeriod
 */
@Repository
public interface BeneficiaryCoolingPeriodRepository extends JpaRepository<BeneficiaryCoolingPeriod, UUID> {

    List<BeneficiaryCoolingPeriod> findByTenantId(UUID tenantId);

    List<BeneficiaryCoolingPeriod> findByUserId(UUID userId);

    Optional<BeneficiaryCoolingPeriod> findBySystemReference(String ref);

    List<BeneficiaryCoolingPeriod> findByOperationalStatus(String status);

    @Query("SELECT e FROM BeneficiaryCoolingPeriod e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BeneficiaryCoolingPeriod> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
