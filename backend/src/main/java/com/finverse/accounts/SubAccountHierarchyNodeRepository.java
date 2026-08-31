package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SubAccountHierarchyNode
 */
@Repository
public interface SubAccountHierarchyNodeRepository extends JpaRepository<SubAccountHierarchyNode, UUID> {

    List<SubAccountHierarchyNode> findByTenantId(UUID tenantId);

    List<SubAccountHierarchyNode> findByUserId(UUID userId);

    Optional<SubAccountHierarchyNode> findBySystemReference(String ref);

    List<SubAccountHierarchyNode> findByOperationalStatus(String status);

    @Query("SELECT e FROM SubAccountHierarchyNode e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SubAccountHierarchyNode> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
