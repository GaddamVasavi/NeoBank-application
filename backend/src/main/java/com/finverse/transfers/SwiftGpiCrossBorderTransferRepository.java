package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SwiftGpiCrossBorderTransfer
 */
@Repository
public interface SwiftGpiCrossBorderTransferRepository extends JpaRepository<SwiftGpiCrossBorderTransfer, UUID> {

    List<SwiftGpiCrossBorderTransfer> findByTenantId(UUID tenantId);

    List<SwiftGpiCrossBorderTransfer> findByUserId(UUID userId);

    Optional<SwiftGpiCrossBorderTransfer> findBySystemReference(String ref);

    List<SwiftGpiCrossBorderTransfer> findByOperationalStatus(String status);

    @Query("SELECT e FROM SwiftGpiCrossBorderTransfer e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SwiftGpiCrossBorderTransfer> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
