package com.finverse.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for MileageTravelLogEntry
 */
@Repository
public interface MileageTravelLogEntryRepository extends JpaRepository<MileageTravelLogEntry, UUID> {

    List<MileageTravelLogEntry> findByTenantId(UUID tenantId);

    List<MileageTravelLogEntry> findByUserId(UUID userId);

    Optional<MileageTravelLogEntry> findBySystemReference(String ref);

    List<MileageTravelLogEntry> findByOperationalStatus(String status);

    @Query("SELECT e FROM MileageTravelLogEntry e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<MileageTravelLogEntry> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
