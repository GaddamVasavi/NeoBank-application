package com.finverse.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CorsAllowedOriginConfig
 */
@Repository
public interface CorsAllowedOriginConfigRepository extends JpaRepository<CorsAllowedOriginConfig, UUID> {

    List<CorsAllowedOriginConfig> findByTenantId(UUID tenantId);

    List<CorsAllowedOriginConfig> findByUserId(UUID userId);

    Optional<CorsAllowedOriginConfig> findBySystemReference(String ref);

    List<CorsAllowedOriginConfig> findByOperationalStatus(String status);

    @Query("SELECT e FROM CorsAllowedOriginConfig e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CorsAllowedOriginConfig> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
