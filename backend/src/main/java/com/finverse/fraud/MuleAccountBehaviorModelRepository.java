package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for MuleAccountBehaviorModel
 */
@Repository
public interface MuleAccountBehaviorModelRepository extends JpaRepository<MuleAccountBehaviorModel, UUID> {

    List<MuleAccountBehaviorModel> findByTenantId(UUID tenantId);

    List<MuleAccountBehaviorModel> findByUserId(UUID userId);

    Optional<MuleAccountBehaviorModel> findBySystemReference(String ref);

    List<MuleAccountBehaviorModel> findByOperationalStatus(String status);

    @Query("SELECT e FROM MuleAccountBehaviorModel e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<MuleAccountBehaviorModel> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
