package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MileageTravelLogEntry
 */
public interface MileageTravelLogEntryService {

    List<MileageTravelLogEntryDto> getByTenant(UUID tenantId);

    List<MileageTravelLogEntryDto> getByUser(UUID userId);

    MileageTravelLogEntryDto create(MileageTravelLogEntryDto dto);

    MileageTravelLogEntryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MileageTravelLogEntryDto> listAll();
}
