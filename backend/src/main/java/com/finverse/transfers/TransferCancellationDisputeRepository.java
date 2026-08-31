package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TransferCancellationDispute
 */
@Repository
public interface TransferCancellationDisputeRepository extends JpaRepository<TransferCancellationDispute, UUID> {

    List<TransferCancellationDispute> findByTenantId(UUID tenantId);

    List<TransferCancellationDispute> findByUserId(UUID userId);

    Optional<TransferCancellationDispute> findBySystemReference(String ref);

    List<TransferCancellationDispute> findByOperationalStatus(String status);

    @Query("SELECT e FROM TransferCancellationDispute e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TransferCancellationDispute> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
