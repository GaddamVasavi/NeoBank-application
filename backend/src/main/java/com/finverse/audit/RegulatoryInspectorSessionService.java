package com.finverse.audit;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RegulatoryInspectorSession
 */
public interface RegulatoryInspectorSessionService {

    List<RegulatoryInspectorSessionDto> getByTenant(UUID tenantId);

    List<RegulatoryInspectorSessionDto> getByUser(UUID userId);

    RegulatoryInspectorSessionDto create(RegulatoryInspectorSessionDto dto);

    RegulatoryInspectorSessionDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RegulatoryInspectorSessionDto> listAll();
}
