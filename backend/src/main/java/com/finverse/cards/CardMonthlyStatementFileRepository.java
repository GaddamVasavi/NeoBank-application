package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardMonthlyStatementFile
 */
@Repository
public interface CardMonthlyStatementFileRepository extends JpaRepository<CardMonthlyStatementFile, UUID> {

    List<CardMonthlyStatementFile> findByTenantId(UUID tenantId);

    List<CardMonthlyStatementFile> findByUserId(UUID userId);

    Optional<CardMonthlyStatementFile> findBySystemReference(String ref);

    List<CardMonthlyStatementFile> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardMonthlyStatementFile e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardMonthlyStatementFile> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
