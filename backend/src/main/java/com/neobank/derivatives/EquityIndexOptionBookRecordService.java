package com.neobank.derivatives;
import java.util.List; import java.util.UUID;
public interface EquityIndexOptionBookRecordService {
    List<EquityIndexOptionBookRecordDto> getByUser(UUID userId);
    EquityIndexOptionBookRecordDto create(EquityIndexOptionBookRecordDto dto);
    EquityIndexOptionBookRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<EquityIndexOptionBookRecordDto> listAll();
}
