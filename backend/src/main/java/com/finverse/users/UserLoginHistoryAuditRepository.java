package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserLoginHistoryAudit
 */
@Repository
public interface UserLoginHistoryAuditRepository extends JpaRepository<UserLoginHistoryAudit, UUID> {

    List<UserLoginHistoryAudit> findByTenantId(UUID tenantId);

    List<UserLoginHistoryAudit> findByUserId(UUID userId);

    Optional<UserLoginHistoryAudit> findBySystemReference(String ref);

    List<UserLoginHistoryAudit> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserLoginHistoryAudit e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserLoginHistoryAudit> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
