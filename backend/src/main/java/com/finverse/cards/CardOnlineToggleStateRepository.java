package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardOnlineToggleState
 */
@Repository
public interface CardOnlineToggleStateRepository extends JpaRepository<CardOnlineToggleState, UUID> {

    List<CardOnlineToggleState> findByTenantId(UUID tenantId);

    List<CardOnlineToggleState> findByUserId(UUID userId);

    Optional<CardOnlineToggleState> findBySystemReference(String ref);

    List<CardOnlineToggleState> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardOnlineToggleState e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardOnlineToggleState> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
