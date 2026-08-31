package com.finverse.capitalmarkets;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MutualFundOrderBookEntry
 */
public interface MutualFundOrderBookEntryService {

    List<MutualFundOrderBookEntryDto> getByTenant(UUID tenantId);

    List<MutualFundOrderBookEntryDto> getByUser(UUID userId);

    MutualFundOrderBookEntryDto create(MutualFundOrderBookEntryDto dto);

    MutualFundOrderBookEntryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MutualFundOrderBookEntryDto> listAll();
}
