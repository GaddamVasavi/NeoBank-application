package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardTransactionAuthorization
 */
public interface CardTransactionAuthorizationService {

    List<CardTransactionAuthorizationDto> getByTenant(UUID tenantId);

    List<CardTransactionAuthorizationDto> getByUser(UUID userId);

    CardTransactionAuthorizationDto create(CardTransactionAuthorizationDto dto);

    CardTransactionAuthorizationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardTransactionAuthorizationDto> listAll();
}
