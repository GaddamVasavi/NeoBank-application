package com.finverse.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SingleSignOnSAMLConfig
 */
@Repository
public interface SingleSignOnSAMLConfigRepository extends JpaRepository<SingleSignOnSAMLConfig, UUID> {

    List<SingleSignOnSAMLConfig> findByTenantId(UUID tenantId);

    List<SingleSignOnSAMLConfig> findByUserId(UUID userId);

    Optional<SingleSignOnSAMLConfig> findBySystemReference(String ref);

    List<SingleSignOnSAMLConfig> findByOperationalStatus(String status);

    @Query("SELECT e FROM SingleSignOnSAMLConfig e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SingleSignOnSAMLConfig> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
