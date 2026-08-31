package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TaxJurisdictionRate
 */
public interface TaxJurisdictionRateService {

    List<TaxJurisdictionRateDto> getByTenant(UUID tenantId);

    List<TaxJurisdictionRateDto> getByUser(UUID userId);

    TaxJurisdictionRateDto create(TaxJurisdictionRateDto dto);

    TaxJurisdictionRateDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TaxJurisdictionRateDto> listAll();
}
