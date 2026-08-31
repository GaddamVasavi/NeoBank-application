package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface LiquidityCoverageRatioMetricService {
    List<LiquidityCoverageRatioMetricDto> getByUser(UUID userId);
    LiquidityCoverageRatioMetricDto create(LiquidityCoverageRatioMetricDto dto);
    LiquidityCoverageRatioMetricDto getByCode(String code);
    void updateState(UUID id, String state);
    List<LiquidityCoverageRatioMetricDto> listAll();
}
