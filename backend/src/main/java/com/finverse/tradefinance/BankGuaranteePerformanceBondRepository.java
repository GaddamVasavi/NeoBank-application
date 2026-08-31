package com.finverse.tradefinance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BankGuaranteePerformanceBond
 */
@Repository
public interface BankGuaranteePerformanceBondRepository extends JpaRepository<BankGuaranteePerformanceBond, UUID> {

    List<BankGuaranteePerformanceBond> findByTenantId(UUID tenantId);

    List<BankGuaranteePerformanceBond> findByUserId(UUID userId);

    Optional<BankGuaranteePerformanceBond> findBySystemReference(String ref);

    List<BankGuaranteePerformanceBond> findByOperationalStatus(String status);

    @Query("SELECT e FROM BankGuaranteePerformanceBond e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BankGuaranteePerformanceBond> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
