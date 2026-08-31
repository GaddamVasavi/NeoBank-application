package com.finverse.privateequity;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PortfolioCompanyValuation
 */
public interface PortfolioCompanyValuationService {

    List<PortfolioCompanyValuationDto> getByTenant(UUID tenantId);

    List<PortfolioCompanyValuationDto> getByUser(UUID userId);

    PortfolioCompanyValuationDto create(PortfolioCompanyValuationDto dto);

    PortfolioCompanyValuationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PortfolioCompanyValuationDto> listAll();
}
