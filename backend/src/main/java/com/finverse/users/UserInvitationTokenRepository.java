package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserInvitationToken
 */
@Repository
public interface UserInvitationTokenRepository extends JpaRepository<UserInvitationToken, UUID> {

    List<UserInvitationToken> findByTenantId(UUID tenantId);

    List<UserInvitationToken> findByUserId(UUID userId);

    Optional<UserInvitationToken> findBySystemReference(String ref);

    List<UserInvitationToken> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserInvitationToken e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserInvitationToken> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
