package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FatcaCrsTaxWithholdingFile
 */
@Repository
public interface FatcaCrsTaxWithholdingFileRepository extends JpaRepository<FatcaCrsTaxWithholdingFile, UUID> {

    List<FatcaCrsTaxWithholdingFile> findByTenantId(UUID tenantId);

    List<FatcaCrsTaxWithholdingFile> findByUserId(UUID userId);

    Optional<FatcaCrsTaxWithholdingFile> findBySystemReference(String ref);

    List<FatcaCrsTaxWithholdingFile> findByOperationalStatus(String status);

    @Query("SELECT e FROM FatcaCrsTaxWithholdingFile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FatcaCrsTaxWithholdingFile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
