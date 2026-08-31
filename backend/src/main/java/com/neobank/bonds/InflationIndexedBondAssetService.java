package com.neobank.bonds;
import java.util.List; import java.util.UUID;
public interface InflationIndexedBondAssetService {
    List<InflationIndexedBondAssetDto> getByUser(UUID userId);
    InflationIndexedBondAssetDto create(InflationIndexedBondAssetDto dto);
    InflationIndexedBondAssetDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<InflationIndexedBondAssetDto> listAll();
}
