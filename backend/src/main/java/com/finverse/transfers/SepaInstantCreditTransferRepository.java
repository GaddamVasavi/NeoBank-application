package com.finverse.transfers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for SepaInstantCreditTransfer
 */
@Repository
public interface SepaInstantCreditTransferRepository extends JpaRepository<SepaInstantCreditTransfer, UUID> {

    List<SepaInstantCreditTransfer> findByTenantId(UUID tenantId);

    List<SepaInstantCreditTransfer> findByUserId(UUID userId);

    Optional<SepaInstantCreditTransfer> findBySystemReference(String ref);

    List<SepaInstantCreditTransfer> findByOperationalStatus(String status);

    @Query("SELECT e FROM SepaInstantCreditTransfer e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<SepaInstantCreditTransfer> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
