package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for NonPerformingLoanWorkout
 */
@Repository
public interface NonPerformingLoanWorkoutRepository extends JpaRepository<NonPerformingLoanWorkout, UUID> {

    List<NonPerformingLoanWorkout> findByTenantId(UUID tenantId);

    List<NonPerformingLoanWorkout> findByUserId(UUID userId);

    Optional<NonPerformingLoanWorkout> findBySystemReference(String ref);

    List<NonPerformingLoanWorkout> findByOperationalStatus(String status);

    @Query("SELECT e FROM NonPerformingLoanWorkout e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<NonPerformingLoanWorkout> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
