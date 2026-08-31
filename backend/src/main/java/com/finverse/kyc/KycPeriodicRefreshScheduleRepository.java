package com.finverse.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for KycPeriodicRefreshSchedule
 */
@Repository
public interface KycPeriodicRefreshScheduleRepository extends JpaRepository<KycPeriodicRefreshSchedule, UUID> {

    List<KycPeriodicRefreshSchedule> findByTenantId(UUID tenantId);

    List<KycPeriodicRefreshSchedule> findByUserId(UUID userId);

    Optional<KycPeriodicRefreshSchedule> findBySystemReference(String ref);

    List<KycPeriodicRefreshSchedule> findByOperationalStatus(String status);

    @Query("SELECT e FROM KycPeriodicRefreshSchedule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<KycPeriodicRefreshSchedule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
