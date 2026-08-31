package com.finverse.tradefinance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CommercialLetterOfCredit
 */
@Repository
public interface CommercialLetterOfCreditRepository extends JpaRepository<CommercialLetterOfCredit, UUID> {

    List<CommercialLetterOfCredit> findByTenantId(UUID tenantId);

    List<CommercialLetterOfCredit> findByUserId(UUID userId);

    Optional<CommercialLetterOfCredit> findBySystemReference(String ref);

    List<CommercialLetterOfCredit> findByOperationalStatus(String status);

    @Query("SELECT e FROM CommercialLetterOfCredit e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CommercialLetterOfCredit> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
