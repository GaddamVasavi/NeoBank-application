package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface CounterpartyExposureRecordService {
    List<CounterpartyExposureRecordDto> getByUser(UUID userId);
    CounterpartyExposureRecordDto create(CounterpartyExposureRecordDto dto);
    CounterpartyExposureRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CounterpartyExposureRecordDto> listAll();
}
