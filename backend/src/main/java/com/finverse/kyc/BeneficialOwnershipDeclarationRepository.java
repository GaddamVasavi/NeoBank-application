package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BeneficialOwnershipDeclaration
 */
@Repository
public interface BeneficialOwnershipDeclarationRepository extends JpaRepository<BeneficialOwnershipDeclaration, UUID> {

    List<BeneficialOwnershipDeclaration> findByTenantId(UUID tenantId);

    List<BeneficialOwnershipDeclaration> findByUserId(UUID userId);

    Optional<BeneficialOwnershipDeclaration> findBySystemReference(String ref);

    List<BeneficialOwnershipDeclaration> findByOperationalStatus(String status);

    @Query("SELECT e FROM BeneficialOwnershipDeclaration e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BeneficialOwnershipDeclaration> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
