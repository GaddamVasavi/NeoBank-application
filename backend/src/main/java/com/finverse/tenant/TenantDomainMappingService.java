package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantDomainMapping
 */
public interface TenantDomainMappingService {

    List<TenantDomainMappingDto> getByTenant(UUID tenantId);

    List<TenantDomainMappingDto> getByUser(UUID userId);

    TenantDomainMappingDto create(TenantDomainMappingDto dto);

    TenantDomainMappingDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantDomainMappingDto> listAll();
}
