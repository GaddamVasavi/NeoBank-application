package com.finverse.admin;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SuperAdminAccessLog
 */
public interface SuperAdminAccessLogService {

    List<SuperAdminAccessLogDto> getByTenant(UUID tenantId);

    List<SuperAdminAccessLogDto> getByUser(UUID userId);

    SuperAdminAccessLogDto create(SuperAdminAccessLogDto dto);

    SuperAdminAccessLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SuperAdminAccessLogDto> listAll();
}
