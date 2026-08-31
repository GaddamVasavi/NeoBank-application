package com.finverse.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RegulatoryInspectorSession
 */
@Repository
public interface RegulatoryInspectorSessionRepository extends JpaRepository<RegulatoryInspectorSession, UUID> {

    List<RegulatoryInspectorSession> findByTenantId(UUID tenantId);

    List<RegulatoryInspectorSession> findByUserId(UUID userId);

    Optional<RegulatoryInspectorSession> findBySystemReference(String ref);

    List<RegulatoryInspectorSession> findByOperationalStatus(String status);

    @Query("SELECT e FROM RegulatoryInspectorSession e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RegulatoryInspectorSession> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
