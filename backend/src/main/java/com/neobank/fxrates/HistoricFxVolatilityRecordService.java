package com.neobank.fxrates;
import java.util.List; import java.util.UUID;
public interface HistoricFxVolatilityRecordService {
    List<HistoricFxVolatilityRecordDto> getByUser(UUID userId);
    HistoricFxVolatilityRecordDto create(HistoricFxVolatilityRecordDto dto);
    HistoricFxVolatilityRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<HistoricFxVolatilityRecordDto> listAll();
}
