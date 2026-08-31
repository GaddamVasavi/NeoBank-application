package com.finverse.treasury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for InterestRateSwapContract
 */
@Repository
public interface InterestRateSwapContractRepository extends JpaRepository<InterestRateSwapContract, UUID> {

    List<InterestRateSwapContract> findByTenantId(UUID tenantId);

    List<InterestRateSwapContract> findByUserId(UUID userId);

    Optional<InterestRateSwapContract> findBySystemReference(String ref);

    List<InterestRateSwapContract> findByOperationalStatus(String status);

    @Query("SELECT e FROM InterestRateSwapContract e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<InterestRateSwapContract> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
