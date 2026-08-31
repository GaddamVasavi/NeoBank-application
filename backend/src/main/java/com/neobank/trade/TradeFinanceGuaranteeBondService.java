package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface TradeFinanceGuaranteeBondService {
    List<TradeFinanceGuaranteeBondDto> getByUser(UUID userId);
    TradeFinanceGuaranteeBondDto create(TradeFinanceGuaranteeBondDto dto);
    TradeFinanceGuaranteeBondDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TradeFinanceGuaranteeBondDto> listAll();
}
