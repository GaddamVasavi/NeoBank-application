package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ForeignCurrencyRevaluation
 */
@Repository
public interface ForeignCurrencyRevaluationRepository extends JpaRepository<ForeignCurrencyRevaluation, UUID> {

    List<ForeignCurrencyRevaluation> findByTenantId(UUID tenantId);

    List<ForeignCurrencyRevaluation> findByUserId(UUID userId);

    Optional<ForeignCurrencyRevaluation> findBySystemReference(String ref);

    List<ForeignCurrencyRevaluation> findByOperationalStatus(String status);

    @Query("SELECT e FROM ForeignCurrencyRevaluation e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ForeignCurrencyRevaluation> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
