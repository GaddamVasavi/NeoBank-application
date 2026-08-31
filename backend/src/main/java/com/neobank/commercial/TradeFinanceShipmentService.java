package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface TradeFinanceShipmentService {
    List<TradeFinanceShipmentDto> getByUser(UUID userId);
    TradeFinanceShipmentDto create(TradeFinanceShipmentDto dto);
    TradeFinanceShipmentDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<TradeFinanceShipmentDto> listAll();
}
