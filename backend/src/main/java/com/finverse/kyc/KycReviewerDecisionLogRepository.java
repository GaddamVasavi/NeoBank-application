package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for KycReviewerDecisionLog
 */
@Repository
public interface KycReviewerDecisionLogRepository extends JpaRepository<KycReviewerDecisionLog, UUID> {

    List<KycReviewerDecisionLog> findByTenantId(UUID tenantId);

    List<KycReviewerDecisionLog> findByUserId(UUID userId);

    Optional<KycReviewerDecisionLog> findBySystemReference(String ref);

    List<KycReviewerDecisionLog> findByOperationalStatus(String status);

    @Query("SELECT e FROM KycReviewerDecisionLog e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<KycReviewerDecisionLog> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
