package com.finverse.admin;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for GlobalConfigurationParameter
 */
public interface GlobalConfigurationParameterService {

    List<GlobalConfigurationParameterDto> getByTenant(UUID tenantId);

    List<GlobalConfigurationParameterDto> getByUser(UUID userId);

    GlobalConfigurationParameterDto create(GlobalConfigurationParameterDto dto);

    GlobalConfigurationParameterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<GlobalConfigurationParameterDto> listAll();
}
