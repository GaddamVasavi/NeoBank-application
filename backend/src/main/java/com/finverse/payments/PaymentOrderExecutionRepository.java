package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentOrderExecution
 */
@Repository
public interface PaymentOrderExecutionRepository extends JpaRepository<PaymentOrderExecution, UUID> {

    List<PaymentOrderExecution> findByTenantId(UUID tenantId);

    List<PaymentOrderExecution> findByUserId(UUID userId);

    Optional<PaymentOrderExecution> findBySystemReference(String ref);

    List<PaymentOrderExecution> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentOrderExecution e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentOrderExecution> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
