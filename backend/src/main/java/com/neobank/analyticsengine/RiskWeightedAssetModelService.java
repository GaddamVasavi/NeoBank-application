package com.neobank.analyticsengine;
import java.util.List; import java.util.UUID;
public interface RiskWeightedAssetModelService {
    List<RiskWeightedAssetModelDto> getByUser(UUID userId);
    RiskWeightedAssetModelDto create(RiskWeightedAssetModelDto dto);
    RiskWeightedAssetModelDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RiskWeightedAssetModelDto> listAll();
}
