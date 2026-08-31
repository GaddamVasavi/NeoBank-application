package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AccountSpendLimitRule
 */
@Repository
public interface AccountSpendLimitRuleRepository extends JpaRepository<AccountSpendLimitRule, UUID> {

    List<AccountSpendLimitRule> findByTenantId(UUID tenantId);

    List<AccountSpendLimitRule> findByUserId(UUID userId);

    Optional<AccountSpendLimitRule> findBySystemReference(String ref);

    List<AccountSpendLimitRule> findByOperationalStatus(String status);

    @Query("SELECT e FROM AccountSpendLimitRule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AccountSpendLimitRule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
