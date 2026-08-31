package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for LoanApplicationDossier
 */
@Repository
public interface LoanApplicationDossierRepository extends JpaRepository<LoanApplicationDossier, UUID> {

    List<LoanApplicationDossier> findByTenantId(UUID tenantId);

    List<LoanApplicationDossier> findByUserId(UUID userId);

    Optional<LoanApplicationDossier> findBySystemReference(String ref);

    List<LoanApplicationDossier> findByOperationalStatus(String status);

    @Query("SELECT e FROM LoanApplicationDossier e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<LoanApplicationDossier> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
