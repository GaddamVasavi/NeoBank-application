package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for HighYieldSavingsAccount
 */
@Repository
public interface HighYieldSavingsAccountRepository extends JpaRepository<HighYieldSavingsAccount, UUID> {

    List<HighYieldSavingsAccount> findByTenantId(UUID tenantId);

    List<HighYieldSavingsAccount> findByUserId(UUID userId);

    Optional<HighYieldSavingsAccount> findBySystemReference(String ref);

    List<HighYieldSavingsAccount> findByOperationalStatus(String status);

    @Query("SELECT e FROM HighYieldSavingsAccount e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<HighYieldSavingsAccount> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
