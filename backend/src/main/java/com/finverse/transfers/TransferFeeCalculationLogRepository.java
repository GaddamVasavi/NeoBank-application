package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TransferFeeCalculationLog
 */
@Repository
public interface TransferFeeCalculationLogRepository extends JpaRepository<TransferFeeCalculationLog, UUID> {

    List<TransferFeeCalculationLog> findByTenantId(UUID tenantId);

    List<TransferFeeCalculationLog> findByUserId(UUID userId);

    Optional<TransferFeeCalculationLog> findBySystemReference(String ref);

    List<TransferFeeCalculationLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM TransferFeeCalculationLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TransferFeeCalculationLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
