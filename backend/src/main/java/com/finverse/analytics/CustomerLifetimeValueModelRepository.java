package com.finverse.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CustomerLifetimeValueModel
 */
@Repository
public interface CustomerLifetimeValueModelRepository extends JpaRepository<CustomerLifetimeValueModel, UUID> {

    List<CustomerLifetimeValueModel> findByTenantId(UUID tenantId);

    List<CustomerLifetimeValueModel> findByUserId(UUID userId);

    Optional<CustomerLifetimeValueModel> findBySystemReference(String ref);

    List<CustomerLifetimeValueModel> findByOperationalStatus(String status);

    @Query("SELECT e FROM CustomerLifetimeValueModel e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CustomerLifetimeValueModel> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
