package com.finverse.interbankclearing;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ContinuousLinkedSettlementPvP
 */
public interface ContinuousLinkedSettlementPvPService {

    List<ContinuousLinkedSettlementPvPDto> getByTenant(UUID tenantId);

    List<ContinuousLinkedSettlementPvPDto> getByUser(UUID userId);

    ContinuousLinkedSettlementPvPDto create(ContinuousLinkedSettlementPvPDto dto);

    ContinuousLinkedSettlementPvPDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ContinuousLinkedSettlementPvPDto> listAll();
}
