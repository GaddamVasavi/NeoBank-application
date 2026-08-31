package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for WorkingCapitalCreditLine
 */
@Repository
public interface WorkingCapitalCreditLineRepository extends JpaRepository<WorkingCapitalCreditLine, UUID> {

    List<WorkingCapitalCreditLine> findByTenantId(UUID tenantId);

    List<WorkingCapitalCreditLine> findByUserId(UUID userId);

    Optional<WorkingCapitalCreditLine> findBySystemReference(String ref);

    List<WorkingCapitalCreditLine> findByOperationalStatus(String status);

    @Query("SELECT e FROM WorkingCapitalCreditLine e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<WorkingCapitalCreditLine> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
