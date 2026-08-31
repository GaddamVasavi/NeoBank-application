package com.finverse.digitalvault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for MpcKeyShamirSecretShare
 */
@Repository
public interface MpcKeyShamirSecretShareRepository extends JpaRepository<MpcKeyShamirSecretShare, UUID> {

    List<MpcKeyShamirSecretShare> findByTenantId(UUID tenantId);

    List<MpcKeyShamirSecretShare> findByUserId(UUID userId);

    Optional<MpcKeyShamirSecretShare> findBySystemReference(String ref);

    List<MpcKeyShamirSecretShare> findByOperationalStatus(String status);

    @Query("SELECT e FROM MpcKeyShamirSecretShare e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<MpcKeyShamirSecretShare> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
