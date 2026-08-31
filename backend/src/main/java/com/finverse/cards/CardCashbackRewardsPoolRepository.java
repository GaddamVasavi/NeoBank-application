package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardCashbackRewardsPool
 */
@Repository
public interface CardCashbackRewardsPoolRepository extends JpaRepository<CardCashbackRewardsPool, UUID> {

    List<CardCashbackRewardsPool> findByTenantId(UUID tenantId);

    List<CardCashbackRewardsPool> findByUserId(UUID userId);

    Optional<CardCashbackRewardsPool> findBySystemReference(String ref);

    List<CardCashbackRewardsPool> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardCashbackRewardsPool e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardCashbackRewardsPool> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
