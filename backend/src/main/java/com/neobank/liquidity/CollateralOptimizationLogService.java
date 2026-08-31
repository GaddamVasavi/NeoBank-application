package com.neobank.liquidity;
import java.util.List; import java.util.UUID;
public interface CollateralOptimizationLogService {
    List<CollateralOptimizationLogDto> getByUser(UUID userId);
    CollateralOptimizationLogDto create(CollateralOptimizationLogDto dto);
    CollateralOptimizationLogDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<CollateralOptimizationLogDto> listAll();
}
