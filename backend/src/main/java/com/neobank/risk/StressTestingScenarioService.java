package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface StressTestingScenarioService {
    List<StressTestingScenarioDto> getByUser(UUID userId);
    StressTestingScenarioDto create(StressTestingScenarioDto dto);
    StressTestingScenarioDto getByCode(String code);
    void updateState(UUID id, String state);
    List<StressTestingScenarioDto> listAll();
}
