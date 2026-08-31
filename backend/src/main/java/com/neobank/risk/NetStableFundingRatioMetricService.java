package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface NetStableFundingRatioMetricService {
    List<NetStableFundingRatioMetricDto> getByUser(UUID userId);
    NetStableFundingRatioMetricDto create(NetStableFundingRatioMetricDto dto);
    NetStableFundingRatioMetricDto getByCode(String code);
    void updateState(UUID id, String state);
    List<NetStableFundingRatioMetricDto> listAll();
}
