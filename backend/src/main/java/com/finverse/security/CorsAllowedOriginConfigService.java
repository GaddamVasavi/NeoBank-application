package com.finverse.security;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CorsAllowedOriginConfig
 */
public interface CorsAllowedOriginConfigService {

    List<CorsAllowedOriginConfigDto> getByTenant(UUID tenantId);

    List<CorsAllowedOriginConfigDto> getByUser(UUID userId);

    CorsAllowedOriginConfigDto create(CorsAllowedOriginConfigDto dto);

    CorsAllowedOriginConfigDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CorsAllowedOriginConfigDto> listAll();
}
