package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardTransactionAuthorization
 */
@Repository
public interface CardTransactionAuthorizationRepository extends JpaRepository<CardTransactionAuthorization, UUID> {

    List<CardTransactionAuthorization> findByTenantId(UUID tenantId);

    List<CardTransactionAuthorization> findByUserId(UUID userId);

    Optional<CardTransactionAuthorization> findBySystemReference(String ref);

    List<CardTransactionAuthorization> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardTransactionAuthorization e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardTransactionAuthorization> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
