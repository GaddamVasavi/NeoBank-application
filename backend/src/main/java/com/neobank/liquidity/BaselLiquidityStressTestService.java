package com.neobank.liquidity;
import java.util.List; import java.util.UUID;
public interface BaselLiquidityStressTestService {
    List<BaselLiquidityStressTestDto> getByUser(UUID userId);
    BaselLiquidityStressTestDto create(BaselLiquidityStressTestDto dto);
    BaselLiquidityStressTestDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<BaselLiquidityStressTestDto> listAll();
}
