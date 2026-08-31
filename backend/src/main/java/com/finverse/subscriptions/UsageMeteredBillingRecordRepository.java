package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UsageMeteredBillingRecord
 */
@Repository
public interface UsageMeteredBillingRecordRepository extends JpaRepository<UsageMeteredBillingRecord, UUID> {

    List<UsageMeteredBillingRecord> findByTenantId(UUID tenantId);

    List<UsageMeteredBillingRecord> findByUserId(UUID userId);

    Optional<UsageMeteredBillingRecord> findBySystemReference(String ref);

    List<UsageMeteredBillingRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM UsageMeteredBillingRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UsageMeteredBillingRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
