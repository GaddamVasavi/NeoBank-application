package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserContactDirectory
 */
@Repository
public interface UserContactDirectoryRepository extends JpaRepository<UserContactDirectory, UUID> {

    List<UserContactDirectory> findByTenantId(UUID tenantId);

    List<UserContactDirectory> findByUserId(UUID userId);

    Optional<UserContactDirectory> findBySystemReference(String ref);

    List<UserContactDirectory> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserContactDirectory e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserContactDirectory> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
