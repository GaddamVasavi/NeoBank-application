package com.finverse.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CardPinSecurityToken
 */
@Repository
public interface CardPinSecurityTokenRepository extends JpaRepository<CardPinSecurityToken, UUID> {

    List<CardPinSecurityToken> findByTenantId(UUID tenantId);

    List<CardPinSecurityToken> findByUserId(UUID userId);

    Optional<CardPinSecurityToken> findBySystemReference(String ref);

    List<CardPinSecurityToken> findByOperationalStatus(String status);

    @Query("SELECT e FROM CardPinSecurityToken e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CardPinSecurityToken> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
