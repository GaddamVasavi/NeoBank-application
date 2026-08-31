package com.finverse.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for TamperEvidentLogVerifier
 */
@Repository
public interface TamperEvidentLogVerifierRepository extends JpaRepository<TamperEvidentLogVerifier, UUID> {

    List<TamperEvidentLogVerifier> findByTenantId(UUID tenantId);

    List<TamperEvidentLogVerifier> findByUserId(UUID userId);

    Optional<TamperEvidentLogVerifier> findBySystemReference(String ref);

    List<TamperEvidentLogVerifier> findByOperationalStatus(String status);

    @Query("SELECT e FROM TamperEvidentLogVerifier e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<TamperEvidentLogVerifier> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
