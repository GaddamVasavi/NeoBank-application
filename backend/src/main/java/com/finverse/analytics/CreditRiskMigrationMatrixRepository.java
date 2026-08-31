package com.finverse.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CreditRiskMigrationMatrix
 */
@Repository
public interface CreditRiskMigrationMatrixRepository extends JpaRepository<CreditRiskMigrationMatrix, UUID> {

    List<CreditRiskMigrationMatrix> findByTenantId(UUID tenantId);

    List<CreditRiskMigrationMatrix> findByUserId(UUID userId);

    Optional<CreditRiskMigrationMatrix> findBySystemReference(String ref);

    List<CreditRiskMigrationMatrix> findByOperationalStatus(String status);

    @Query("SELECT e FROM CreditRiskMigrationMatrix e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CreditRiskMigrationMatrix> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
