package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AmlTransactionMonitoringAlert
 */
@Repository
public interface AmlTransactionMonitoringAlertRepository extends JpaRepository<AmlTransactionMonitoringAlert, UUID> {

    List<AmlTransactionMonitoringAlert> findByTenantId(UUID tenantId);

    List<AmlTransactionMonitoringAlert> findByUserId(UUID userId);

    Optional<AmlTransactionMonitoringAlert> findBySystemReference(String ref);

    List<AmlTransactionMonitoringAlert> findByOperationalStatus(String status);

    @Query("SELECT e FROM AmlTransactionMonitoringAlert e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AmlTransactionMonitoringAlert> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
