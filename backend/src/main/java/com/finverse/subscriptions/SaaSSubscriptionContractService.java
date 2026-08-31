package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SaaSSubscriptionContract
 */
public interface SaaSSubscriptionContractService {

    List<SaaSSubscriptionContractDto> getByTenant(UUID tenantId);

    List<SaaSSubscriptionContractDto> getByUser(UUID userId);

    SaaSSubscriptionContractDto create(SaaSSubscriptionContractDto dto);

    SaaSSubscriptionContractDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SaaSSubscriptionContractDto> listAll();
}
