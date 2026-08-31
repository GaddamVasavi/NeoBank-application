package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardPinSecurityToken
 */
public interface CardPinSecurityTokenService {

    List<CardPinSecurityTokenDto> getByTenant(UUID tenantId);

    List<CardPinSecurityTokenDto> getByUser(UUID userId);

    CardPinSecurityTokenDto create(CardPinSecurityTokenDto dto);

    CardPinSecurityTokenDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardPinSecurityTokenDto> listAll();
}
