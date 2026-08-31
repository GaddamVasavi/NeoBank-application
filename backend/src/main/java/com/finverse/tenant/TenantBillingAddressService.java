package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantBillingAddress
 */
public interface TenantBillingAddressService {

    List<TenantBillingAddressDto> getByTenant(UUID tenantId);

    List<TenantBillingAddressDto> getByUser(UUID userId);

    TenantBillingAddressDto create(TenantBillingAddressDto dto);

    TenantBillingAddressDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantBillingAddressDto> listAll();
}
