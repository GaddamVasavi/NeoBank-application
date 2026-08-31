package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface WarehouseReceiptCollateralService {
    List<WarehouseReceiptCollateralDto> getByUser(UUID userId);
    WarehouseReceiptCollateralDto create(WarehouseReceiptCollateralDto dto);
    WarehouseReceiptCollateralDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<WarehouseReceiptCollateralDto> listAll();
}
