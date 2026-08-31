package com.finverse.compliance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for GdprDataErasureRequest
 */
@Repository
public interface GdprDataErasureRequestRepository extends JpaRepository<GdprDataErasureRequest, UUID> {

    List<GdprDataErasureRequest> findByTenantId(UUID tenantId);

    List<GdprDataErasureRequest> findByUserId(UUID userId);

    Optional<GdprDataErasureRequest> findBySystemReference(String ref);

    List<GdprDataErasureRequest> findByOperationalStatus(String status);

    @Query("SELECT e FROM GdprDataErasureRequest e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<GdprDataErasureRequest> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
