package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FedwireFundsTransfer
 */
@Repository
public interface FedwireFundsTransferRepository extends JpaRepository<FedwireFundsTransfer, UUID> {

    List<FedwireFundsTransfer> findByTenantId(UUID tenantId);

    List<FedwireFundsTransfer> findByUserId(UUID userId);

    Optional<FedwireFundsTransfer> findBySystemReference(String ref);

    List<FedwireFundsTransfer> findByOperationalStatus(String status);

    @Query("SELECT e FROM FedwireFundsTransfer e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FedwireFundsTransfer> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
