package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardSpendLimitControls
 */
@Repository
public interface CardSpendLimitControlsRepository extends JpaRepository<CardSpendLimitControls, UUID> {

    List<CardSpendLimitControls> findByTenantId(UUID tenantId);

    List<CardSpendLimitControls> findByUserId(UUID userId);

    Optional<CardSpendLimitControls> findBySystemReference(String ref);

    List<CardSpendLimitControls> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardSpendLimitControls e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardSpendLimitControls> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
