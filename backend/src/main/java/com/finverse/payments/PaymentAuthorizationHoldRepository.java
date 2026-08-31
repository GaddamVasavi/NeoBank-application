package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentAuthorizationHold
 */
@Repository
public interface PaymentAuthorizationHoldRepository extends JpaRepository<PaymentAuthorizationHold, UUID> {

    List<PaymentAuthorizationHold> findByTenantId(UUID tenantId);

    List<PaymentAuthorizationHold> findByUserId(UUID userId);

    Optional<PaymentAuthorizationHold> findBySystemReference(String ref);

    List<PaymentAuthorizationHold> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentAuthorizationHold e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentAuthorizationHold> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
