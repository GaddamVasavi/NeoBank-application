package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface InterbankLiquiditySwapLogService {
    List<InterbankLiquiditySwapLogDto> getByUser(UUID userId);
    InterbankLiquiditySwapLogDto create(InterbankLiquiditySwapLogDto dto);
    InterbankLiquiditySwapLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<InterbankLiquiditySwapLogDto> listAll();
}
