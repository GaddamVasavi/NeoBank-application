package com.neobank.liquidity;
import java.util.List; import java.util.UUID;
public interface IntradayLiquidityFacilityLogService {
    List<IntradayLiquidityFacilityLogDto> getByUser(UUID userId);
    IntradayLiquidityFacilityLogDto create(IntradayLiquidityFacilityLogDto dto);
    IntradayLiquidityFacilityLogDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<IntradayLiquidityFacilityLogDto> listAll();
}
