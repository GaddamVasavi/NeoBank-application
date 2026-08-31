package com.finverse.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SuperAdminAccessLog
 */
@Repository
public interface SuperAdminAccessLogRepository extends JpaRepository<SuperAdminAccessLog, UUID> {

    List<SuperAdminAccessLog> findByTenantId(UUID tenantId);

    List<SuperAdminAccessLog> findByUserId(UUID userId);

    Optional<SuperAdminAccessLog> findBySystemReference(String ref);

    List<SuperAdminAccessLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM SuperAdminAccessLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SuperAdminAccessLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
