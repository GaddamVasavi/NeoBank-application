package com.neobank.bonds;
import java.util.List; import java.util.UUID;
public interface ConvertibleBondHybridAssetService {
    List<ConvertibleBondHybridAssetDto> getByUser(UUID userId);
    ConvertibleBondHybridAssetDto create(ConvertibleBondHybridAssetDto dto);
    ConvertibleBondHybridAssetDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<ConvertibleBondHybridAssetDto> listAll();
}
