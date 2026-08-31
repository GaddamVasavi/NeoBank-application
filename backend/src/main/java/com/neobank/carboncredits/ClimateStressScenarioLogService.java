package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface ClimateStressScenarioLogService {
    List<ClimateStressScenarioLogDto> getByUser(UUID userId);
    ClimateStressScenarioLogDto create(ClimateStressScenarioLogDto dto);
    ClimateStressScenarioLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ClimateStressScenarioLogDto> listAll();
}
