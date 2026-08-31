package com.finverse.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for RefreshTokenFamilyChain
 */
@Repository
public interface RefreshTokenFamilyChainRepository extends JpaRepository<RefreshTokenFamilyChain, UUID> {

    List<RefreshTokenFamilyChain> findByTenantId(UUID tenantId);

    List<RefreshTokenFamilyChain> findByUserId(UUID userId);

    Optional<RefreshTokenFamilyChain> findBySystemReference(String ref);

    List<RefreshTokenFamilyChain> findByOperationalStatus(String status);

    @Query("SELECT e FROM RefreshTokenFamilyChain e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<RefreshTokenFamilyChain> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
