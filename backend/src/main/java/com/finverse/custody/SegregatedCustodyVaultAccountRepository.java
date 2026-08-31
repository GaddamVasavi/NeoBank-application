package com.finverse.custody;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SegregatedCustodyVaultAccount
 */
@Repository
public interface SegregatedCustodyVaultAccountRepository extends JpaRepository<SegregatedCustodyVaultAccount, UUID> {

    List<SegregatedCustodyVaultAccount> findByTenantId(UUID tenantId);

    List<SegregatedCustodyVaultAccount> findByUserId(UUID userId);

    Optional<SegregatedCustodyVaultAccount> findBySystemReference(String ref);

    List<SegregatedCustodyVaultAccount> findByOperationalStatus(String status);

    @Query("SELECT e FROM SegregatedCustodyVaultAccount e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SegregatedCustodyVaultAccount> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
