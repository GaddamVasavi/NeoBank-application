package com.finverse.capitalmarkets;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for InflationIndexedBondAsset
 */
public interface InflationIndexedBondAssetService {

    List<InflationIndexedBondAssetDto> getByTenant(UUID tenantId);

    List<InflationIndexedBondAssetDto> getByUser(UUID userId);

    InflationIndexedBondAssetDto create(InflationIndexedBondAssetDto dto);

    InflationIndexedBondAssetDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<InflationIndexedBondAssetDto> listAll();
}
