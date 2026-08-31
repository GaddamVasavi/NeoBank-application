package com.finverse.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SmsGatewayTransmissionLog
 */
@Repository
public interface SmsGatewayTransmissionLogRepository extends JpaRepository<SmsGatewayTransmissionLog, UUID> {

    List<SmsGatewayTransmissionLog> findByTenantId(UUID tenantId);

    List<SmsGatewayTransmissionLog> findByUserId(UUID userId);

    Optional<SmsGatewayTransmissionLog> findBySystemReference(String ref);

    List<SmsGatewayTransmissionLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM SmsGatewayTransmissionLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SmsGatewayTransmissionLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
