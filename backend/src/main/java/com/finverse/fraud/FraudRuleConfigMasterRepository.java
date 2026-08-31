package com.finverse.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for FraudRuleConfigMaster
 */
@Repository
public interface FraudRuleConfigMasterRepository extends JpaRepository<FraudRuleConfigMaster, UUID> {

    List<FraudRuleConfigMaster> findByTenantId(UUID tenantId);

    List<FraudRuleConfigMaster> findByUserId(UUID userId);

    Optional<FraudRuleConfigMaster> findBySystemReference(String ref);

    List<FraudRuleConfigMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM FraudRuleConfigMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<FraudRuleConfigMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
