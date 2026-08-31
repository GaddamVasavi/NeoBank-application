package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface RedisCachePerformanceMetricService {
    List<RedisCachePerformanceMetricDto> getByUser(UUID userId);
    RedisCachePerformanceMetricDto create(RedisCachePerformanceMetricDto dto);
    RedisCachePerformanceMetricDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RedisCachePerformanceMetricDto> listAll();
}
