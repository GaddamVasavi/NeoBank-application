package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MuleAccountBehaviorModel
 */
public interface MuleAccountBehaviorModelService {

    List<MuleAccountBehaviorModelDto> getByTenant(UUID tenantId);

    List<MuleAccountBehaviorModelDto> getByUser(UUID userId);

    MuleAccountBehaviorModelDto create(MuleAccountBehaviorModelDto dto);

    MuleAccountBehaviorModelDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MuleAccountBehaviorModelDto> listAll();
}
