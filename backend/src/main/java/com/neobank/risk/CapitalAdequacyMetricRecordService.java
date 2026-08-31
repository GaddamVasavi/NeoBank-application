package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface CapitalAdequacyMetricRecordService {
    List<CapitalAdequacyMetricRecordDto> getByUser(UUID userId);
    CapitalAdequacyMetricRecordDto create(CapitalAdequacyMetricRecordDto dto);
    CapitalAdequacyMetricRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CapitalAdequacyMetricRecordDto> listAll();
}
