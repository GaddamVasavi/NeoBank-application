package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TradeSanctionsVesselCheck
 */
public interface TradeSanctionsVesselCheckService {

    List<TradeSanctionsVesselCheckDto> getByTenant(UUID tenantId);

    List<TradeSanctionsVesselCheckDto> getByUser(UUID userId);

    TradeSanctionsVesselCheckDto create(TradeSanctionsVesselCheckDto dto);

    TradeSanctionsVesselCheckDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TradeSanctionsVesselCheckDto> listAll();
}
