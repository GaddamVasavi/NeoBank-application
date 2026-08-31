package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ProrationAdjustmentLog
 */
@Repository
public interface ProrationAdjustmentLogRepository extends JpaRepository<ProrationAdjustmentLog, UUID> {

    List<ProrationAdjustmentLog> findByTenantId(UUID tenantId);

    List<ProrationAdjustmentLog> findByUserId(UUID userId);

    Optional<ProrationAdjustmentLog> findBySystemReference(String ref);

    List<ProrationAdjustmentLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM ProrationAdjustmentLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ProrationAdjustmentLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
