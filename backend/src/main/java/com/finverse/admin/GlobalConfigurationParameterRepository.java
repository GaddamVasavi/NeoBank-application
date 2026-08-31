package com.finverse.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for GlobalConfigurationParameter
 */
@Repository
public interface GlobalConfigurationParameterRepository extends JpaRepository<GlobalConfigurationParameter, UUID> {

    List<GlobalConfigurationParameter> findByTenantId(UUID tenantId);

    List<GlobalConfigurationParameter> findByUserId(UUID userId);

    Optional<GlobalConfigurationParameter> findBySystemReference(String ref);

    List<GlobalConfigurationParameter> findByOperationalStatus(String status);

    @Query("SELECT e FROM GlobalConfigurationParameter e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<GlobalConfigurationParameter> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
