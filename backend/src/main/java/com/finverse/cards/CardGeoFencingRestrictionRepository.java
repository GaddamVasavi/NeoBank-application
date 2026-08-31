package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardGeoFencingRestriction
 */
@Repository
public interface CardGeoFencingRestrictionRepository extends JpaRepository<CardGeoFencingRestriction, UUID> {

    List<CardGeoFencingRestriction> findByTenantId(UUID tenantId);

    List<CardGeoFencingRestriction> findByUserId(UUID userId);

    Optional<CardGeoFencingRestriction> findBySystemReference(String ref);

    List<CardGeoFencingRestriction> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardGeoFencingRestriction e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardGeoFencingRestriction> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
