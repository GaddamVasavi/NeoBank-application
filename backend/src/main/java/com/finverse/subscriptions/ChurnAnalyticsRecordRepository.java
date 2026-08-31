package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ChurnAnalyticsRecord
 */
@Repository
public interface ChurnAnalyticsRecordRepository extends JpaRepository<ChurnAnalyticsRecord, UUID> {

    List<ChurnAnalyticsRecord> findByTenantId(UUID tenantId);

    List<ChurnAnalyticsRecord> findByUserId(UUID userId);

    Optional<ChurnAnalyticsRecord> findBySystemReference(String ref);

    List<ChurnAnalyticsRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM ChurnAnalyticsRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ChurnAnalyticsRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
