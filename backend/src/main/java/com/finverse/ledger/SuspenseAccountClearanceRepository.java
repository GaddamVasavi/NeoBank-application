package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SuspenseAccountClearance
 */
@Repository
public interface SuspenseAccountClearanceRepository extends JpaRepository<SuspenseAccountClearance, UUID> {

    List<SuspenseAccountClearance> findByTenantId(UUID tenantId);

    List<SuspenseAccountClearance> findByUserId(UUID userId);

    Optional<SuspenseAccountClearance> findBySystemReference(String ref);

    List<SuspenseAccountClearance> findByOperationalStatus(String status);

    @Query("SELECT e FROM SuspenseAccountClearance e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SuspenseAccountClearance> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
