package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TransferOtpApprovalChallenge
 */
@Repository
public interface TransferOtpApprovalChallengeRepository extends JpaRepository<TransferOtpApprovalChallenge, UUID> {

    List<TransferOtpApprovalChallenge> findByTenantId(UUID tenantId);

    List<TransferOtpApprovalChallenge> findByUserId(UUID userId);

    Optional<TransferOtpApprovalChallenge> findBySystemReference(String ref);

    List<TransferOtpApprovalChallenge> findByOperationalStatus(String status);

    @Query("SELECT e FROM TransferOtpApprovalChallenge e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TransferOtpApprovalChallenge> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
