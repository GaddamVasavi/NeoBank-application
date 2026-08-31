package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PerDiemAllowanceSchedule
 */
@Repository
public interface PerDiemAllowanceScheduleRepository extends JpaRepository<PerDiemAllowanceSchedule, UUID> {

    List<PerDiemAllowanceSchedule> findByTenantId(UUID tenantId);

    List<PerDiemAllowanceSchedule> findByUserId(UUID userId);

    Optional<PerDiemAllowanceSchedule> findBySystemReference(String ref);

    List<PerDiemAllowanceSchedule> findByOperationalStatus(String status);

    @Query("SELECT e FROM PerDiemAllowanceSchedule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PerDiemAllowanceSchedule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
