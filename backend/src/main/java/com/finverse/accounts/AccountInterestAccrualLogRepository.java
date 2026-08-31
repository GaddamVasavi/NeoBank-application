package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AccountInterestAccrualLog
 */
@Repository
public interface AccountInterestAccrualLogRepository extends JpaRepository<AccountInterestAccrualLog, UUID> {

    List<AccountInterestAccrualLog> findByTenantId(UUID tenantId);

    List<AccountInterestAccrualLog> findByUserId(UUID userId);

    Optional<AccountInterestAccrualLog> findBySystemReference(String ref);

    List<AccountInterestAccrualLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM AccountInterestAccrualLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AccountInterestAccrualLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
