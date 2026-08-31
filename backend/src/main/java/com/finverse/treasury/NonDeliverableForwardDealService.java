package com.finverse.treasury;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for NonDeliverableForwardDeal
 */
public interface NonDeliverableForwardDealService {

    List<NonDeliverableForwardDealDto> getByTenant(UUID tenantId);

    List<NonDeliverableForwardDealDto> getByUser(UUID userId);

    NonDeliverableForwardDealDto create(NonDeliverableForwardDealDto dto);

    NonDeliverableForwardDealDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<NonDeliverableForwardDealDto> listAll();
}
