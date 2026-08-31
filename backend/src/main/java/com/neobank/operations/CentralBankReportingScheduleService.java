package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface CentralBankReportingScheduleService {
    List<CentralBankReportingScheduleDto> getByUser(UUID userId);
    CentralBankReportingScheduleDto create(CentralBankReportingScheduleDto dto);
    CentralBankReportingScheduleDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CentralBankReportingScheduleDto> listAll();
}
