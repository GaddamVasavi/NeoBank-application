package com.finverse.treasury;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InterestRateSwapContract
 */
public interface InterestRateSwapContractService {

    List<InterestRateSwapContractDto> getByTenant(UUID tenantId);

    List<InterestRateSwapContractDto> getByUser(UUID userId);

    InterestRateSwapContractDto create(InterestRateSwapContractDto dto);

    InterestRateSwapContractDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InterestRateSwapContractDto> listAll();
}
