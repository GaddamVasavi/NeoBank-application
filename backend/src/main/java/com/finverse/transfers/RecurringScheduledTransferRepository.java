package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RecurringScheduledTransfer
 */
@Repository
public interface RecurringScheduledTransferRepository extends JpaRepository<RecurringScheduledTransfer, UUID> {

    List<RecurringScheduledTransfer> findByTenantId(UUID tenantId);

    List<RecurringScheduledTransfer> findByUserId(UUID userId);

    Optional<RecurringScheduledTransfer> findBySystemReference(String ref);

    List<RecurringScheduledTransfer> findByOperationalStatus(String status);

    @Query("SELECT e FROM RecurringScheduledTransfer e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RecurringScheduledTransfer> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
