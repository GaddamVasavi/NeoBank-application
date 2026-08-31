package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardReissueLostStolen
 */
public interface CardReissueLostStolenService {

    List<CardReissueLostStolenDto> getByTenant(UUID tenantId);

    List<CardReissueLostStolenDto> getByUser(UUID userId);

    CardReissueLostStolenDto create(CardReissueLostStolenDto dto);

    CardReissueLostStolenDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardReissueLostStolenDto> listAll();
}
