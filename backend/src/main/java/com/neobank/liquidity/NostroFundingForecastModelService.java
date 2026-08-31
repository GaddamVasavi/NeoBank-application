package com.neobank.liquidity;
import java.util.List; import java.util.UUID;
public interface NostroFundingForecastModelService {
    List<NostroFundingForecastModelDto> getByUser(UUID userId);
    NostroFundingForecastModelDto create(NostroFundingForecastModelDto dto);
    NostroFundingForecastModelDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<NostroFundingForecastModelDto> listAll();
}
