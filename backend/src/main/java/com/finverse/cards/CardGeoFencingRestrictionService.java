package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardGeoFencingRestriction
 */
public interface CardGeoFencingRestrictionService {

    List<CardGeoFencingRestrictionDto> getByTenant(UUID tenantId);

    List<CardGeoFencingRestrictionDto> getByUser(UUID userId);

    CardGeoFencingRestrictionDto create(CardGeoFencingRestrictionDto dto);

    CardGeoFencingRestrictionDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardGeoFencingRestrictionDto> listAll();
}
