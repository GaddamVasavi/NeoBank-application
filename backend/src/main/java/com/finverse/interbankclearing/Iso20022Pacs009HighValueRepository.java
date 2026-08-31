package com.finverse.interbankclearing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for Iso20022Pacs009HighValue
 */
@Repository
public interface Iso20022Pacs009HighValueRepository extends JpaRepository<Iso20022Pacs009HighValue, UUID> {

    List<Iso20022Pacs009HighValue> findByTenantId(UUID tenantId);

    List<Iso20022Pacs009HighValue> findByUserId(UUID userId);

    Optional<Iso20022Pacs009HighValue> findBySystemReference(String ref);

    List<Iso20022Pacs009HighValue> findByOperationalStatus(String status);

    @Query("SELECT e FROM Iso20022Pacs009HighValue e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<Iso20022Pacs009HighValue> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
