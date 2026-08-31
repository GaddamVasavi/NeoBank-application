package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AchNachaBatchTransfer
 */
@Repository
public interface AchNachaBatchTransferRepository extends JpaRepository<AchNachaBatchTransfer, UUID> {

    List<AchNachaBatchTransfer> findByTenantId(UUID tenantId);

    List<AchNachaBatchTransfer> findByUserId(UUID userId);

    Optional<AchNachaBatchTransfer> findBySystemReference(String ref);

    List<AchNachaBatchTransfer> findByOperationalStatus(String status);

    @Query("SELECT e FROM AchNachaBatchTransfer e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AchNachaBatchTransfer> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
