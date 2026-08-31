package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentRoutingRuleConfig
 */
@Repository
public interface PaymentRoutingRuleConfigRepository extends JpaRepository<PaymentRoutingRuleConfig, UUID> {

    List<PaymentRoutingRuleConfig> findByTenantId(UUID tenantId);

    List<PaymentRoutingRuleConfig> findByUserId(UUID userId);

    Optional<PaymentRoutingRuleConfig> findBySystemReference(String ref);

    List<PaymentRoutingRuleConfig> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentRoutingRuleConfig e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentRoutingRuleConfig> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
