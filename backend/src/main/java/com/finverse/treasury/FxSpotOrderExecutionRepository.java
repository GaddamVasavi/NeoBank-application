package com.finverse.treasury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FxSpotOrderExecution
 */
@Repository
public interface FxSpotOrderExecutionRepository extends JpaRepository<FxSpotOrderExecution, UUID> {

    List<FxSpotOrderExecution> findByTenantId(UUID tenantId);

    List<FxSpotOrderExecution> findByUserId(UUID userId);

    Optional<FxSpotOrderExecution> findBySystemReference(String ref);

    List<FxSpotOrderExecution> findByOperationalStatus(String status);

    @Query("SELECT e FROM FxSpotOrderExecution e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FxSpotOrderExecution> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
