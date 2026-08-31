package com.finverse.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ImmutableAuditBlockRecord
 */
@Repository
public interface ImmutableAuditBlockRecordRepository extends JpaRepository<ImmutableAuditBlockRecord, UUID> {

    List<ImmutableAuditBlockRecord> findByTenantId(UUID tenantId);

    List<ImmutableAuditBlockRecord> findByUserId(UUID userId);

    Optional<ImmutableAuditBlockRecord> findBySystemReference(String ref);

    List<ImmutableAuditBlockRecord> findByOperationalStatus(String status);

    @Query("SELECT e FROM ImmutableAuditBlockRecord e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ImmutableAuditBlockRecord> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
