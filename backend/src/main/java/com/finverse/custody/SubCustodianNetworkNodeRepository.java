package com.finverse.custody;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SubCustodianNetworkNode
 */
@Repository
public interface SubCustodianNetworkNodeRepository extends JpaRepository<SubCustodianNetworkNode, UUID> {

    List<SubCustodianNetworkNode> findByTenantId(UUID tenantId);

    List<SubCustodianNetworkNode> findByUserId(UUID userId);

    Optional<SubCustodianNetworkNode> findBySystemReference(String ref);

    List<SubCustodianNetworkNode> findByOperationalStatus(String status);

    @Query("SELECT e FROM SubCustodianNetworkNode e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SubCustodianNetworkNode> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
