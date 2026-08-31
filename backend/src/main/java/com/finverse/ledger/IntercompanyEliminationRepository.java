package com.finverse.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for IntercompanyElimination
 */
@Repository
public interface IntercompanyEliminationRepository extends JpaRepository<IntercompanyElimination, UUID> {

    List<IntercompanyElimination> findByTenantId(UUID tenantId);

    List<IntercompanyElimination> findByUserId(UUID userId);

    Optional<IntercompanyElimination> findBySystemReference(String ref);

    List<IntercompanyElimination> findByOperationalStatus(String status);

    @Query("SELECT e FROM IntercompanyElimination e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<IntercompanyElimination> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
