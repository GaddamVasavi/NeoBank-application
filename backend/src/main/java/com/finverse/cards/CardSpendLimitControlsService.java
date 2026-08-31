package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardSpendLimitControls
 */
public interface CardSpendLimitControlsService {

    List<CardSpendLimitControlsDto> getByTenant(UUID tenantId);

    List<CardSpendLimitControlsDto> getByUser(UUID userId);

    CardSpendLimitControlsDto create(CardSpendLimitControlsDto dto);

    CardSpendLimitControlsDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardSpendLimitControlsDto> listAll();
}
