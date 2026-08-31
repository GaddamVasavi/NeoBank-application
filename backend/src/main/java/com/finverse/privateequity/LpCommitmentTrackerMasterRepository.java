package com.finverse.privateequity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for LpCommitmentTrackerMaster
 */
@Repository
public interface LpCommitmentTrackerMasterRepository extends JpaRepository<LpCommitmentTrackerMaster, UUID> {

    List<LpCommitmentTrackerMaster> findByTenantId(UUID tenantId);

    List<LpCommitmentTrackerMaster> findByUserId(UUID userId);

    Optional<LpCommitmentTrackerMaster> findBySystemReference(String ref);

    List<LpCommitmentTrackerMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM LpCommitmentTrackerMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<LpCommitmentTrackerMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
