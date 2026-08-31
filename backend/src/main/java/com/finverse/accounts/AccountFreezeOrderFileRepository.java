package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AccountFreezeOrderFile
 */
@Repository
public interface AccountFreezeOrderFileRepository extends JpaRepository<AccountFreezeOrderFile, UUID> {

    List<AccountFreezeOrderFile> findByTenantId(UUID tenantId);

    List<AccountFreezeOrderFile> findByUserId(UUID userId);

    Optional<AccountFreezeOrderFile> findBySystemReference(String ref);

    List<AccountFreezeOrderFile> findByOperationalStatus(String status);

    @Query("SELECT e FROM AccountFreezeOrderFile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AccountFreezeOrderFile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
