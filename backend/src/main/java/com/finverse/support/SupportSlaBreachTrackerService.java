package com.finverse.support;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SupportSlaBreachTracker
 */
public interface SupportSlaBreachTrackerService {

    List<SupportSlaBreachTrackerDto> getByTenant(UUID tenantId);

    List<SupportSlaBreachTrackerDto> getByUser(UUID userId);

    SupportSlaBreachTrackerDto create(SupportSlaBreachTrackerDto dto);

    SupportSlaBreachTrackerDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SupportSlaBreachTrackerDto> listAll();
}
