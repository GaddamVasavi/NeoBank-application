package com.finverse.digitalvault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ClientSecureDepositVaultFile
 */
@Repository
public interface ClientSecureDepositVaultFileRepository extends JpaRepository<ClientSecureDepositVaultFile, UUID> {

    List<ClientSecureDepositVaultFile> findByTenantId(UUID tenantId);

    List<ClientSecureDepositVaultFile> findByUserId(UUID userId);

    Optional<ClientSecureDepositVaultFile> findBySystemReference(String ref);

    List<ClientSecureDepositVaultFile> findByOperationalStatus(String status);

    @Query("SELECT e FROM ClientSecureDepositVaultFile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ClientSecureDepositVaultFile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
