package com.finverse.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CustomerSupportTicket
 */
@Repository
public interface CustomerSupportTicketRepository extends JpaRepository<CustomerSupportTicket, UUID> {

    List<CustomerSupportTicket> findByTenantId(UUID tenantId);

    List<CustomerSupportTicket> findByUserId(UUID userId);

    Optional<CustomerSupportTicket> findBySystemReference(String ref);

    List<CustomerSupportTicket> findByOperationalStatus(String status);

    @Query("SELECT e FROM CustomerSupportTicket e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CustomerSupportTicket> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
