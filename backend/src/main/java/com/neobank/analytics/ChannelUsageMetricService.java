package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface ChannelUsageMetricService {
    List<ChannelUsageMetricDto> getByUser(UUID userId);
    ChannelUsageMetricDto create(ChannelUsageMetricDto dto);
    ChannelUsageMetricDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<ChannelUsageMetricDto> listAll();
}
