package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for LoanAmortizationSchedule
 */
@Repository
public interface LoanAmortizationScheduleRepository extends JpaRepository<LoanAmortizationSchedule, UUID> {

    List<LoanAmortizationSchedule> findByTenantId(UUID tenantId);

    List<LoanAmortizationSchedule> findByUserId(UUID userId);

    Optional<LoanAmortizationSchedule> findBySystemReference(String ref);

    List<LoanAmortizationSchedule> findByOperationalStatus(String status);

    @Query("SELECT e FROM LoanAmortizationSchedule e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<LoanAmortizationSchedule> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
