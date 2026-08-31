package com.finverse.interbankclearing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ContinuousLinkedSettlementPvP
 */
@Repository
public interface ContinuousLinkedSettlementPvPRepository extends JpaRepository<ContinuousLinkedSettlementPvP, UUID> {

    List<ContinuousLinkedSettlementPvP> findByTenantId(UUID tenantId);

    List<ContinuousLinkedSettlementPvP> findByUserId(UUID userId);

    Optional<ContinuousLinkedSettlementPvP> findBySystemReference(String ref);

    List<ContinuousLinkedSettlementPvP> findByOperationalStatus(String status);

    @Query("SELECT e FROM ContinuousLinkedSettlementPvP e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ContinuousLinkedSettlementPvP> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
