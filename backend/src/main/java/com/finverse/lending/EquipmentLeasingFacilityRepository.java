package com.finverse.lending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for EquipmentLeasingFacility
 */
@Repository
public interface EquipmentLeasingFacilityRepository extends JpaRepository<EquipmentLeasingFacility, UUID> {

    List<EquipmentLeasingFacility> findByTenantId(UUID tenantId);

    List<EquipmentLeasingFacility> findByUserId(UUID userId);

    Optional<EquipmentLeasingFacility> findBySystemReference(String ref);

    List<EquipmentLeasingFacility> findByOperationalStatus(String status);

    @Query("SELECT e FROM EquipmentLeasingFacility e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<EquipmentLeasingFacility> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
