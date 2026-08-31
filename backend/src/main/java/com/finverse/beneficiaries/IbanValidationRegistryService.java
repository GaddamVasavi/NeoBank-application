package com.finverse.beneficiaries;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for IbanValidationRegistry
 */
public interface IbanValidationRegistryService {

    List<IbanValidationRegistryDto> getByTenant(UUID tenantId);

    List<IbanValidationRegistryDto> getByUser(UUID userId);

    IbanValidationRegistryDto create(IbanValidationRegistryDto dto);

    IbanValidationRegistryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<IbanValidationRegistryDto> listAll();
}
