package com.finverse.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SupportTicketMessageThread
 */
@Repository
public interface SupportTicketMessageThreadRepository extends JpaRepository<SupportTicketMessageThread, UUID> {

    List<SupportTicketMessageThread> findByTenantId(UUID tenantId);

    List<SupportTicketMessageThread> findByUserId(UUID userId);

    Optional<SupportTicketMessageThread> findBySystemReference(String ref);

    List<SupportTicketMessageThread> findByOperationalStatus(String status);

    @Query("SELECT e FROM SupportTicketMessageThread e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SupportTicketMessageThread> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
