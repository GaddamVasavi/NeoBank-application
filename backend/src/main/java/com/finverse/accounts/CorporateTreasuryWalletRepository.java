package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CorporateTreasuryWallet
 */
@Repository
public interface CorporateTreasuryWalletRepository extends JpaRepository<CorporateTreasuryWallet, UUID> {

    List<CorporateTreasuryWallet> findByTenantId(UUID tenantId);

    List<CorporateTreasuryWallet> findByUserId(UUID userId);

    Optional<CorporateTreasuryWallet> findBySystemReference(String ref);

    List<CorporateTreasuryWallet> findByOperationalStatus(String status);

    @Query("SELECT e FROM CorporateTreasuryWallet e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CorporateTreasuryWallet> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
