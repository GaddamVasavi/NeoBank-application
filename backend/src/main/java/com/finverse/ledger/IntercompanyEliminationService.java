package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for IntercompanyElimination
 */
public interface IntercompanyEliminationService {

    List<IntercompanyEliminationDto> getByTenant(UUID tenantId);

    List<IntercompanyEliminationDto> getByUser(UUID userId);

    IntercompanyEliminationDto create(IntercompanyEliminationDto dto);

    IntercompanyEliminationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<IntercompanyEliminationDto> listAll();
}
