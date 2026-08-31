package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ProductCatalogMaster
 */
public interface ProductCatalogMasterService {

    List<ProductCatalogMasterDto> getByTenant(UUID tenantId);

    List<ProductCatalogMasterDto> getByUser(UUID userId);

    ProductCatalogMasterDto create(ProductCatalogMasterDto dto);

    ProductCatalogMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ProductCatalogMasterDto> listAll();
}
