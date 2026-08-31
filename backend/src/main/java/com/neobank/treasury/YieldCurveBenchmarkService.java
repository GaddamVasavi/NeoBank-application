package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface YieldCurveBenchmarkService {
    List<YieldCurveBenchmarkDto> getByUser(UUID userId);
    YieldCurveBenchmarkDto create(YieldCurveBenchmarkDto dto);
    YieldCurveBenchmarkDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<YieldCurveBenchmarkDto> listAll();
}
