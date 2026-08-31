package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardReissueLostStolen
 */
@Repository
public interface CardReissueLostStolenRepository extends JpaRepository<CardReissueLostStolen, UUID> {

    List<CardReissueLostStolen> findByTenantId(UUID tenantId);

    List<CardReissueLostStolen> findByUserId(UUID userId);

    Optional<CardReissueLostStolen> findBySystemReference(String ref);

    List<CardReissueLostStolen> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardReissueLostStolen e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardReissueLostStolen> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
