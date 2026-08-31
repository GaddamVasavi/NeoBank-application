package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface DepositGrowthTrajectoryService {
    List<DepositGrowthTrajectoryDto> getByUser(UUID userId);
    DepositGrowthTrajectoryDto create(DepositGrowthTrajectoryDto dto);
    DepositGrowthTrajectoryDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<DepositGrowthTrajectoryDto> listAll();
}
