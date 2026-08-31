package com.finverse.treasury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CashPoolingSweepStructure
 */
@Repository
public interface CashPoolingSweepStructureRepository extends JpaRepository<CashPoolingSweepStructure, UUID> {

    List<CashPoolingSweepStructure> findByTenantId(UUID tenantId);

    List<CashPoolingSweepStructure> findByUserId(UUID userId);

    Optional<CashPoolingSweepStructure> findBySystemReference(String ref);

    List<CashPoolingSweepStructure> findByOperationalStatus(String status);

    @Query("SELECT e FROM CashPoolingSweepStructure e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CashPoolingSweepStructure> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
