package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardOnlineToggleState
 */
public interface CardOnlineToggleStateService {

    List<CardOnlineToggleStateDto> getByTenant(UUID tenantId);

    List<CardOnlineToggleStateDto> getByUser(UUID userId);

    CardOnlineToggleStateDto create(CardOnlineToggleStateDto dto);

    CardOnlineToggleStateDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardOnlineToggleStateDto> listAll();
}
