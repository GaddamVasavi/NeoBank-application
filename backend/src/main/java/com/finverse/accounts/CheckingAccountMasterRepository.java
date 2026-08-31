package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CheckingAccountMaster
 */
@Repository
public interface CheckingAccountMasterRepository extends JpaRepository<CheckingAccountMaster, UUID> {

    List<CheckingAccountMaster> findByTenantId(UUID tenantId);

    List<CheckingAccountMaster> findByUserId(UUID userId);

    Optional<CheckingAccountMaster> findBySystemReference(String ref);

    List<CheckingAccountMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM CheckingAccountMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CheckingAccountMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
