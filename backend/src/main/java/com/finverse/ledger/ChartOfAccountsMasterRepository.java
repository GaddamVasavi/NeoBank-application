package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ChartOfAccountsMaster
 */
@Repository
public interface ChartOfAccountsMasterRepository extends JpaRepository<ChartOfAccountsMaster, UUID> {

    List<ChartOfAccountsMaster> findByTenantId(UUID tenantId);

    List<ChartOfAccountsMaster> findByUserId(UUID userId);

    Optional<ChartOfAccountsMaster> findBySystemReference(String ref);

    List<ChartOfAccountsMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM ChartOfAccountsMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ChartOfAccountsMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
