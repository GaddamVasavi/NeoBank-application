package com.finverse.capitalmarkets;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for GreenBondIssuanceMaster
 */
public interface GreenBondIssuanceMasterService {

    List<GreenBondIssuanceMasterDto> getByTenant(UUID tenantId);

    List<GreenBondIssuanceMasterDto> getByUser(UUID userId);

    GreenBondIssuanceMasterDto create(GreenBondIssuanceMasterDto dto);

    GreenBondIssuanceMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<GreenBondIssuanceMasterDto> listAll();
}
