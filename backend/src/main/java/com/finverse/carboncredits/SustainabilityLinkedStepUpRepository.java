package com.finverse.carboncredits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SustainabilityLinkedStepUp
 */
@Repository
public interface SustainabilityLinkedStepUpRepository extends JpaRepository<SustainabilityLinkedStepUp, UUID> {

    List<SustainabilityLinkedStepUp> findByTenantId(UUID tenantId);

    List<SustainabilityLinkedStepUp> findByUserId(UUID userId);

    Optional<SustainabilityLinkedStepUp> findBySystemReference(String ref);

    List<SustainabilityLinkedStepUp> findByOperationalStatus(String status);

    @Query("SELECT e FROM SustainabilityLinkedStepUp e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SustainabilityLinkedStepUp> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
