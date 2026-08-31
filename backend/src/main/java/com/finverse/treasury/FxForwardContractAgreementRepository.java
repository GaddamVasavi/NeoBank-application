package com.finverse.treasury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FxForwardContractAgreement
 */
@Repository
public interface FxForwardContractAgreementRepository extends JpaRepository<FxForwardContractAgreement, UUID> {

    List<FxForwardContractAgreement> findByTenantId(UUID tenantId);

    List<FxForwardContractAgreement> findByUserId(UUID userId);

    Optional<FxForwardContractAgreement> findBySystemReference(String ref);

    List<FxForwardContractAgreement> findByOperationalStatus(String status);

    @Query("SELECT e FROM FxForwardContractAgreement e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FxForwardContractAgreement> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
