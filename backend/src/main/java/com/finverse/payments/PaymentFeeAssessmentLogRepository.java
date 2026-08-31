package com.finverse.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for PaymentFeeAssessmentLog
 */
@Repository
public interface PaymentFeeAssessmentLogRepository extends JpaRepository<PaymentFeeAssessmentLog, UUID> {

    List<PaymentFeeAssessmentLog> findByTenantId(UUID tenantId);

    List<PaymentFeeAssessmentLog> findByUserId(UUID userId);

    Optional<PaymentFeeAssessmentLog> findBySystemReference(String ref);

    List<PaymentFeeAssessmentLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM PaymentFeeAssessmentLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<PaymentFeeAssessmentLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
