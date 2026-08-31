package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ApiKeyCredentialRegistry
 */
public interface ApiKeyCredentialRegistryService {

    List<ApiKeyCredentialRegistryDto> getByTenant(UUID tenantId);

    List<ApiKeyCredentialRegistryDto> getByUser(UUID userId);

    ApiKeyCredentialRegistryDto create(ApiKeyCredentialRegistryDto dto);

    ApiKeyCredentialRegistryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ApiKeyCredentialRegistryDto> listAll();
}
