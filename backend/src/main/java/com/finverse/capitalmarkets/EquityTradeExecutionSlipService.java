package com.finverse.capitalmarkets;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EquityTradeExecutionSlip
 */
public interface EquityTradeExecutionSlipService {

    List<EquityTradeExecutionSlipDto> getByTenant(UUID tenantId);

    List<EquityTradeExecutionSlipDto> getByUser(UUID userId);

    EquityTradeExecutionSlipDto create(EquityTradeExecutionSlipDto dto);

    EquityTradeExecutionSlipDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EquityTradeExecutionSlipDto> listAll();
}
