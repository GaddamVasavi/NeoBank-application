package com.finverse.beneficiaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TrustedBeneficiaryProfile
 */
@Repository
public interface TrustedBeneficiaryProfileRepository extends JpaRepository<TrustedBeneficiaryProfile, UUID> {

    List<TrustedBeneficiaryProfile> findByTenantId(UUID tenantId);

    List<TrustedBeneficiaryProfile> findByUserId(UUID userId);

    Optional<TrustedBeneficiaryProfile> findBySystemReference(String ref);

    List<TrustedBeneficiaryProfile> findByOperationalStatus(String status);

    @Query("SELECT e FROM TrustedBeneficiaryProfile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TrustedBeneficiaryProfile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
