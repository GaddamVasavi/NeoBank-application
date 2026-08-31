package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CustomerBillingProfile
 */
public interface CustomerBillingProfileService {

    List<CustomerBillingProfileDto> getByTenant(UUID tenantId);

    List<CustomerBillingProfileDto> getByUser(UUID userId);

    CustomerBillingProfileDto create(CustomerBillingProfileDto dto);

    CustomerBillingProfileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CustomerBillingProfileDto> listAll();
}
