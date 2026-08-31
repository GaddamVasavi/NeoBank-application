package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface CommodityTradeFinanceDealService {
    List<CommodityTradeFinanceDealDto> getByUser(UUID userId);
    CommodityTradeFinanceDealDto create(CommodityTradeFinanceDealDto dto);
    CommodityTradeFinanceDealDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CommodityTradeFinanceDealDto> listAll();
}
