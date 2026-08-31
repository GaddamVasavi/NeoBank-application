package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SingleSignOnSAMLConfig
 */
public interface SingleSignOnSAMLConfigService {

    List<SingleSignOnSAMLConfigDto> getByTenant(UUID tenantId);

    List<SingleSignOnSAMLConfigDto> getByUser(UUID userId);

    SingleSignOnSAMLConfigDto create(SingleSignOnSAMLConfigDto dto);

    SingleSignOnSAMLConfigDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SingleSignOnSAMLConfigDto> listAll();
}
