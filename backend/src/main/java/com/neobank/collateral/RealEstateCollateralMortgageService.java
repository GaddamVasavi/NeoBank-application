package com.neobank.collateral;
import java.util.List; import java.util.UUID;
public interface RealEstateCollateralMortgageService {
    List<RealEstateCollateralMortgageDto> getByUser(UUID userId);
    RealEstateCollateralMortgageDto create(RealEstateCollateralMortgageDto dto);
    RealEstateCollateralMortgageDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RealEstateCollateralMortgageDto> listAll();
}
