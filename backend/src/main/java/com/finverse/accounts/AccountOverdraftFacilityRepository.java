package com.finverse.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for AccountOverdraftFacility
 */
@Repository
public interface AccountOverdraftFacilityRepository extends JpaRepository<AccountOverdraftFacility, UUID> {

    List<AccountOverdraftFacility> findByTenantId(UUID tenantId);

    List<AccountOverdraftFacility> findByUserId(UUID userId);

    Optional<AccountOverdraftFacility> findBySystemReference(String ref);

    List<AccountOverdraftFacility> findByOperationalStatus(String status);

    @Query("SELECT e FROM AccountOverdraftFacility e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<AccountOverdraftFacility> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
