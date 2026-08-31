package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TransferFxHedgingSlip
 */
@Repository
public interface TransferFxHedgingSlipRepository extends JpaRepository<TransferFxHedgingSlip, UUID> {

    List<TransferFxHedgingSlip> findByTenantId(UUID tenantId);

    List<TransferFxHedgingSlip> findByUserId(UUID userId);

    Optional<TransferFxHedgingSlip> findBySystemReference(String ref);

    List<TransferFxHedgingSlip> findByOperationalStatus(String status);

    @Query("SELECT e FROM TransferFxHedgingSlip e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TransferFxHedgingSlip> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
