package com.neobank.collateral;
import java.util.List; import java.util.UUID;
public interface CommodityWarehouseCollateralService {
    List<CommodityWarehouseCollateralDto> getByUser(UUID userId);
    CommodityWarehouseCollateralDto create(CommodityWarehouseCollateralDto dto);
    CommodityWarehouseCollateralDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CommodityWarehouseCollateralDto> listAll();
}
