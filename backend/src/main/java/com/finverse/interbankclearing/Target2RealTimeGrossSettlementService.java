package com.finverse.interbankclearing;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for Target2RealTimeGrossSettlement
 */
public interface Target2RealTimeGrossSettlementService {

    List<Target2RealTimeGrossSettlementDto> getByTenant(UUID tenantId);

    List<Target2RealTimeGrossSettlementDto> getByUser(UUID userId);

    Target2RealTimeGrossSettlementDto create(Target2RealTimeGrossSettlementDto dto);

    Target2RealTimeGrossSettlementDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<Target2RealTimeGrossSettlementDto> listAll();
}
