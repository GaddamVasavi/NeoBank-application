package com.finverse.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PasswordResetSessionToken
 */
@Repository
public interface PasswordResetSessionTokenRepository extends JpaRepository<PasswordResetSessionToken, UUID> {

    List<PasswordResetSessionToken> findByTenantId(UUID tenantId);

    List<PasswordResetSessionToken> findByUserId(UUID userId);

    Optional<PasswordResetSessionToken> findBySystemReference(String ref);

    List<PasswordResetSessionToken> findByOperationalStatus(String status);

    @Query("SELECT e FROM PasswordResetSessionToken e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PasswordResetSessionToken> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
