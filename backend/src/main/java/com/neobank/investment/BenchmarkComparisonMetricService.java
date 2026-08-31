package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface BenchmarkComparisonMetricService {
    List<BenchmarkComparisonMetricDto> getByUser(UUID userId);
    BenchmarkComparisonMetricDto create(BenchmarkComparisonMetricDto dto);
    BenchmarkComparisonMetricDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<BenchmarkComparisonMetricDto> listAll();
}
