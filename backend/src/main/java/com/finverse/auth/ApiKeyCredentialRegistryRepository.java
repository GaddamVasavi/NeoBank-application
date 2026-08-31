package com.finverse.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ApiKeyCredentialRegistry
 */
@Repository
public interface ApiKeyCredentialRegistryRepository extends JpaRepository<ApiKeyCredentialRegistry, UUID> {

    List<ApiKeyCredentialRegistry> findByTenantId(UUID tenantId);

    List<ApiKeyCredentialRegistry> findByUserId(UUID userId);

    Optional<ApiKeyCredentialRegistry> findBySystemReference(String ref);

    List<ApiKeyCredentialRegistry> findByOperationalStatus(String status);

    @Query("SELECT e FROM ApiKeyCredentialRegistry e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ApiKeyCredentialRegistry> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
