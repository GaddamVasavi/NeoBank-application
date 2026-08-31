package com.finverse.analytics;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CustomerLifetimeValueModel
 */
public interface CustomerLifetimeValueModelService {

    List<CustomerLifetimeValueModelDto> getByTenant(UUID tenantId);

    List<CustomerLifetimeValueModelDto> getByUser(UUID userId);

    CustomerLifetimeValueModelDto create(CustomerLifetimeValueModelDto dto);

    CustomerLifetimeValueModelDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CustomerLifetimeValueModelDto> listAll();
}
