package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserDelegationRule
 */
@Repository
public interface UserDelegationRuleRepository extends JpaRepository<UserDelegationRule, UUID> {

    List<UserDelegationRule> findByTenantId(UUID tenantId);

    List<UserDelegationRule> findByUserId(UUID userId);

    Optional<UserDelegationRule> findBySystemReference(String ref);

    List<UserDelegationRule> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserDelegationRule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserDelegationRule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
