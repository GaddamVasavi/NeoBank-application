package com.finverse.interbankclearing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ChipsIntradaySettlementSlip
 */
@Repository
public interface ChipsIntradaySettlementSlipRepository extends JpaRepository<ChipsIntradaySettlementSlip, UUID> {

    List<ChipsIntradaySettlementSlip> findByTenantId(UUID tenantId);

    List<ChipsIntradaySettlementSlip> findByUserId(UUID userId);

    Optional<ChipsIntradaySettlementSlip> findBySystemReference(String ref);

    List<ChipsIntradaySettlementSlip> findByOperationalStatus(String status);

    @Query("SELECT e FROM ChipsIntradaySettlementSlip e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ChipsIntradaySettlementSlip> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
