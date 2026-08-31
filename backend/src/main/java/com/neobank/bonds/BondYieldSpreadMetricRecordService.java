package com.neobank.bonds;
import java.util.List; import java.util.UUID;
public interface BondYieldSpreadMetricRecordService {
    List<BondYieldSpreadMetricRecordDto> getByUser(UUID userId);
    BondYieldSpreadMetricRecordDto create(BondYieldSpreadMetricRecordDto dto);
    BondYieldSpreadMetricRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BondYieldSpreadMetricRecordDto> listAll();
}
