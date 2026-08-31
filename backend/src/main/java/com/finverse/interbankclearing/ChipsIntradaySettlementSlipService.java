package com.finverse.interbankclearing;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ChipsIntradaySettlementSlip
 */
public interface ChipsIntradaySettlementSlipService {

    List<ChipsIntradaySettlementSlipDto> getByTenant(UUID tenantId);

    List<ChipsIntradaySettlementSlipDto> getByUser(UUID userId);

    ChipsIntradaySettlementSlipDto create(ChipsIntradaySettlementSlipDto dto);

    ChipsIntradaySettlementSlipDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ChipsIntradaySettlementSlipDto> listAll();
}
