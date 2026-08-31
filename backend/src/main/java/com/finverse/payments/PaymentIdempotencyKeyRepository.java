package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentIdempotencyKey
 */
@Repository
public interface PaymentIdempotencyKeyRepository extends JpaRepository<PaymentIdempotencyKey, UUID> {

    List<PaymentIdempotencyKey> findByTenantId(UUID tenantId);

    List<PaymentIdempotencyKey> findByUserId(UUID userId);

    Optional<PaymentIdempotencyKey> findBySystemReference(String ref);

    List<PaymentIdempotencyKey> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentIdempotencyKey e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentIdempotencyKey> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
