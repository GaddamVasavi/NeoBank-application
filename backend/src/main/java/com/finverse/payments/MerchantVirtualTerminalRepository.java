package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for MerchantVirtualTerminal
 */
@Repository
public interface MerchantVirtualTerminalRepository extends JpaRepository<MerchantVirtualTerminal, UUID> {

    List<MerchantVirtualTerminal> findByTenantId(UUID tenantId);

    List<MerchantVirtualTerminal> findByUserId(UUID userId);

    Optional<MerchantVirtualTerminal> findBySystemReference(String ref);

    List<MerchantVirtualTerminal> findByOperationalStatus(String status);

    @Query("SELECT e FROM MerchantVirtualTerminal e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<MerchantVirtualTerminal> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
