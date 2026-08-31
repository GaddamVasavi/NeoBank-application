package com.neobank.derivatives;
import java.util.List; import java.util.UUID;
public interface CommodityFutureContractDealService {
    List<CommodityFutureContractDealDto> getByUser(UUID userId);
    CommodityFutureContractDealDto create(CommodityFutureContractDealDto dto);
    CommodityFutureContractDealDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CommodityFutureContractDealDto> listAll();
}
