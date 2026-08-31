package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PhysicalCardIssuanceFile
 */
@Repository
public interface PhysicalCardIssuanceFileRepository extends JpaRepository<PhysicalCardIssuanceFile, UUID> {

    List<PhysicalCardIssuanceFile> findByTenantId(UUID tenantId);

    List<PhysicalCardIssuanceFile> findByUserId(UUID userId);

    Optional<PhysicalCardIssuanceFile> findBySystemReference(String ref);

    List<PhysicalCardIssuanceFile> findByOperationalStatus(String status);

    @Query("SELECT e FROM PhysicalCardIssuanceFile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PhysicalCardIssuanceFile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
