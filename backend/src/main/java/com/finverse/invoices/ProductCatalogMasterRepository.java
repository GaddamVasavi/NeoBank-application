package com.finverse.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ProductCatalogMaster
 */
@Repository
public interface ProductCatalogMasterRepository extends JpaRepository<ProductCatalogMaster, UUID> {

    List<ProductCatalogMaster> findByTenantId(UUID tenantId);

    List<ProductCatalogMaster> findByUserId(UUID userId);

    Optional<ProductCatalogMaster> findBySystemReference(String ref);

    List<ProductCatalogMaster> findByOperationalStatus(String status);

    @Query("SELECT e FROM ProductCatalogMaster e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<ProductCatalogMaster> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
