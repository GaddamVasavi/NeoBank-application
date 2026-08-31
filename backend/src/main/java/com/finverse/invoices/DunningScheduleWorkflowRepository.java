package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for DunningScheduleWorkflow
 */
@Repository
public interface DunningScheduleWorkflowRepository extends JpaRepository<DunningScheduleWorkflow, UUID> {

    List<DunningScheduleWorkflow> findByTenantId(UUID tenantId);

    List<DunningScheduleWorkflow> findByUserId(UUID userId);

    Optional<DunningScheduleWorkflow> findBySystemReference(String ref);

    List<DunningScheduleWorkflow> findByOperationalStatus(String status);

    @Query("SELECT e FROM DunningScheduleWorkflow e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<DunningScheduleWorkflow> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
