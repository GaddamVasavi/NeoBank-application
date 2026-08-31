package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EnterpriseAddonFeature
 */
@Repository
public interface EnterpriseAddonFeatureRepository extends JpaRepository<EnterpriseAddonFeature, UUID> {

    List<EnterpriseAddonFeature> findByTenantId(UUID tenantId);

    List<EnterpriseAddonFeature> findByUserId(UUID userId);

    Optional<EnterpriseAddonFeature> findBySystemReference(String ref);

    List<EnterpriseAddonFeature> findByOperationalStatus(String status);

    @Query("SELECT e FROM EnterpriseAddonFeature e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EnterpriseAddonFeature> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
