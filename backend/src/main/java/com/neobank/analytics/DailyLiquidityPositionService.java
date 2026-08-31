package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface DailyLiquidityPositionService {
    List<DailyLiquidityPositionDto> getByUser(UUID userId);
    DailyLiquidityPositionDto create(DailyLiquidityPositionDto dto);
    DailyLiquidityPositionDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<DailyLiquidityPositionDto> listAll();
}
