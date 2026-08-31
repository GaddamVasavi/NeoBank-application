package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RegulatoryInquiryDossier
 */
@Repository
public interface RegulatoryInquiryDossierRepository extends JpaRepository<RegulatoryInquiryDossier, UUID> {

    List<RegulatoryInquiryDossier> findByTenantId(UUID tenantId);

    List<RegulatoryInquiryDossier> findByUserId(UUID userId);

    Optional<RegulatoryInquiryDossier> findBySystemReference(String ref);

    List<RegulatoryInquiryDossier> findByOperationalStatus(String status);

    @Query("SELECT e FROM RegulatoryInquiryDossier e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RegulatoryInquiryDossier> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
