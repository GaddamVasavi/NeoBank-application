package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ProofOfAddressDocument
 */
@Repository
public interface ProofOfAddressDocumentRepository extends JpaRepository<ProofOfAddressDocument, UUID> {

    List<ProofOfAddressDocument> findByTenantId(UUID tenantId);

    List<ProofOfAddressDocument> findByUserId(UUID userId);

    Optional<ProofOfAddressDocument> findBySystemReference(String ref);

    List<ProofOfAddressDocument> findByOperationalStatus(String status);

    @Query("SELECT e FROM ProofOfAddressDocument e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ProofOfAddressDocument> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
