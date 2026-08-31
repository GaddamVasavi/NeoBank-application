package com.finverse.privateequity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CapitalCallDrawdownNotice
 */
@Repository
public interface CapitalCallDrawdownNoticeRepository extends JpaRepository<CapitalCallDrawdownNotice, UUID> {

    List<CapitalCallDrawdownNotice> findByTenantId(UUID tenantId);

    List<CapitalCallDrawdownNotice> findByUserId(UUID userId);

    Optional<CapitalCallDrawdownNotice> findBySystemReference(String ref);

    List<CapitalCallDrawdownNotice> findByOperationalStatus(String status);

    @Query("SELECT e FROM CapitalCallDrawdownNotice e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CapitalCallDrawdownNotice> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
