package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FraudAlertInvestigationCase
 */
@Repository
public interface FraudAlertInvestigationCaseRepository extends JpaRepository<FraudAlertInvestigationCase, UUID> {

    List<FraudAlertInvestigationCase> findByTenantId(UUID tenantId);

    List<FraudAlertInvestigationCase> findByUserId(UUID userId);

    Optional<FraudAlertInvestigationCase> findBySystemReference(String ref);

    List<FraudAlertInvestigationCase> findByOperationalStatus(String status);

    @Query("SELECT e FROM FraudAlertInvestigationCase e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FraudAlertInvestigationCase> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
