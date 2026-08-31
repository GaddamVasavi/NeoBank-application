package com.finverse.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserDepartmentHierarchy
 */
@Repository
public interface UserDepartmentHierarchyRepository extends JpaRepository<UserDepartmentHierarchy, UUID> {

    List<UserDepartmentHierarchy> findByTenantId(UUID tenantId);

    List<UserDepartmentHierarchy> findByUserId(UUID userId);

    Optional<UserDepartmentHierarchy> findBySystemReference(String ref);

    List<UserDepartmentHierarchy> findByOperationalStatus(String status);

    @Query("SELECT e FROM UserDepartmentHierarchy e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<UserDepartmentHierarchy> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
