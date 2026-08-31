package com.finverse.capitalmarkets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EquityTradeExecutionSlip
 */
@Repository
public interface EquityTradeExecutionSlipRepository extends JpaRepository<EquityTradeExecutionSlip, UUID> {

    List<EquityTradeExecutionSlip> findByTenantId(UUID tenantId);

    List<EquityTradeExecutionSlip> findByUserId(UUID userId);

    Optional<EquityTradeExecutionSlip> findBySystemReference(String ref);

    List<EquityTradeExecutionSlip> findByOperationalStatus(String status);

    @Query("SELECT e FROM EquityTradeExecutionSlip e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EquityTradeExecutionSlip> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
