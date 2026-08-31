package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for VirtualCardTokenMaster
 */
@Repository
public interface VirtualCardTokenMasterRepository extends JpaRepository<VirtualCardTokenMaster, UUID> {

    List<VirtualCardTokenMaster> findByTenantId(UUID tenantId);

    List<VirtualCardTokenMaster> findByUserId(UUID userId);

    Optional<VirtualCardTokenMaster> findBySystemReference(String ref);

    List<VirtualCardTokenMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM VirtualCardTokenMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<VirtualCardTokenMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
