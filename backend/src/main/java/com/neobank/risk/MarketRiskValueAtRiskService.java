package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface MarketRiskValueAtRiskService {
    List<MarketRiskValueAtRiskDto> getByUser(UUID userId);
    MarketRiskValueAtRiskDto create(MarketRiskValueAtRiskDto dto);
    MarketRiskValueAtRiskDto getByCode(String code);
    void updateState(UUID id, String state);
    List<MarketRiskValueAtRiskDto> listAll();
}
