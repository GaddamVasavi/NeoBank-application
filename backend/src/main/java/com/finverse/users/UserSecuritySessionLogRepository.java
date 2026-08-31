package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserSecuritySessionLog
 */
@Repository
public interface UserSecuritySessionLogRepository extends JpaRepository<UserSecuritySessionLog, UUID> {

    List<UserSecuritySessionLog> findByTenantId(UUID tenantId);

    List<UserSecuritySessionLog> findByUserId(UUID userId);

    Optional<UserSecuritySessionLog> findBySystemReference(String ref);

    List<UserSecuritySessionLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserSecuritySessionLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserSecuritySessionLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
