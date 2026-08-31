package com.finverse.interbankclearing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for Target2RealTimeGrossSettlement
 */
@Repository
public interface Target2RealTimeGrossSettlementRepository extends JpaRepository<Target2RealTimeGrossSettlement, UUID> {

    List<Target2RealTimeGrossSettlement> findByTenantId(UUID tenantId);

    List<Target2RealTimeGrossSettlement> findByUserId(UUID userId);

    Optional<Target2RealTimeGrossSettlement> findBySystemReference(String ref);

    List<Target2RealTimeGrossSettlement> findByOperationalStatus(String status);

    @Query("SELECT e FROM Target2RealTimeGrossSettlement e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<Target2RealTimeGrossSettlement> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
