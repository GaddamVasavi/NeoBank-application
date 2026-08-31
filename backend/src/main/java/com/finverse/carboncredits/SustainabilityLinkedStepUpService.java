package com.finverse.carboncredits;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SustainabilityLinkedStepUp
 */
public interface SustainabilityLinkedStepUpService {

    List<SustainabilityLinkedStepUpDto> getByTenant(UUID tenantId);

    List<SustainabilityLinkedStepUpDto> getByUser(UUID userId);

    SustainabilityLinkedStepUpDto create(SustainabilityLinkedStepUpDto dto);

    SustainabilityLinkedStepUpDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SustainabilityLinkedStepUpDto> listAll();
}
