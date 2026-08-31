package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for BookTransferTransaction
 */
@Repository
public interface BookTransferTransactionRepository extends JpaRepository<BookTransferTransaction, UUID> {

    List<BookTransferTransaction> findByTenantId(UUID tenantId);

    List<BookTransferTransaction> findByUserId(UUID userId);

    Optional<BookTransferTransaction> findBySystemReference(String ref);

    List<BookTransferTransaction> findByOperationalStatus(String status);

    @Query("SELECT e FROM BookTransferTransaction e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<BookTransferTransaction> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
