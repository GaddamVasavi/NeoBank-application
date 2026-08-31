package com.finverse.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AuthMfaEnrollmentMaster
 */
@Repository
public interface AuthMfaEnrollmentMasterRepository extends JpaRepository<AuthMfaEnrollmentMaster, UUID> {

    List<AuthMfaEnrollmentMaster> findByTenantId(UUID tenantId);

    List<AuthMfaEnrollmentMaster> findByUserId(UUID userId);

    Optional<AuthMfaEnrollmentMaster> findBySystemReference(String ref);

    List<AuthMfaEnrollmentMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM AuthMfaEnrollmentMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AuthMfaEnrollmentMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
