package com.neobank.bonds;
import java.util.List; import java.util.UUID;
public interface MunicipalBondPortfolioAssetService {
    List<MunicipalBondPortfolioAssetDto> getByUser(UUID userId);
    MunicipalBondPortfolioAssetDto create(MunicipalBondPortfolioAssetDto dto);
    MunicipalBondPortfolioAssetDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<MunicipalBondPortfolioAssetDto> listAll();
}
