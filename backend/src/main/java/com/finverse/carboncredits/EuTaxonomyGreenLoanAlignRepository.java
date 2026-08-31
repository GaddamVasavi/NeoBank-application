package com.finverse.carboncredits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EuTaxonomyGreenLoanAlign
 */
@Repository
public interface EuTaxonomyGreenLoanAlignRepository extends JpaRepository<EuTaxonomyGreenLoanAlign, UUID> {

    List<EuTaxonomyGreenLoanAlign> findByTenantId(UUID tenantId);

    List<EuTaxonomyGreenLoanAlign> findByUserId(UUID userId);

    Optional<EuTaxonomyGreenLoanAlign> findBySystemReference(String ref);

    List<EuTaxonomyGreenLoanAlign> findByOperationalStatus(String status);

    @Query("SELECT e FROM EuTaxonomyGreenLoanAlign e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EuTaxonomyGreenLoanAlign> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
