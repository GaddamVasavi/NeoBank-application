package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface MoneyMarketPlacementService {
    List<MoneyMarketPlacementDto> getByUser(UUID userId);
    MoneyMarketPlacementDto create(MoneyMarketPlacementDto dto);
    MoneyMarketPlacementDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<MoneyMarketPlacementDto> listAll();
}
