package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SecurityAlertIncidentLog
 */
public interface SecurityAlertIncidentLogService {

    List<SecurityAlertIncidentLogDto> getByTenant(UUID tenantId);

    List<SecurityAlertIncidentLogDto> getByUser(UUID userId);

    SecurityAlertIncidentLogDto create(SecurityAlertIncidentLogDto dto);

    SecurityAlertIncidentLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SecurityAlertIncidentLogDto> listAll();
}
