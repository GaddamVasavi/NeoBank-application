package com.finverse.carboncredits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CarbonOffsetRegistrySerial
 */
@Repository
public interface CarbonOffsetRegistrySerialRepository extends JpaRepository<CarbonOffsetRegistrySerial, UUID> {

    List<CarbonOffsetRegistrySerial> findByTenantId(UUID tenantId);

    List<CarbonOffsetRegistrySerial> findByUserId(UUID userId);

    Optional<CarbonOffsetRegistrySerial> findBySystemReference(String ref);

    List<CarbonOffsetRegistrySerial> findByOperationalStatus(String status);

    @Query("SELECT e FROM CarbonOffsetRegistrySerial e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CarbonOffsetRegistrySerial> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
