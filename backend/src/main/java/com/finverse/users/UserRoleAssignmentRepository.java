package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserRoleAssignment
 */
@Repository
public interface UserRoleAssignmentRepository extends JpaRepository<UserRoleAssignment, UUID> {

    List<UserRoleAssignment> findByTenantId(UUID tenantId);

    List<UserRoleAssignment> findByUserId(UUID userId);

    Optional<UserRoleAssignment> findBySystemReference(String ref);

    List<UserRoleAssignment> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserRoleAssignment e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserRoleAssignment> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
