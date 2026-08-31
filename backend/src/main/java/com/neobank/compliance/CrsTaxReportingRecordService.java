package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface CrsTaxReportingRecordService {
    List<CrsTaxReportingRecordDto> getByUser(UUID userId);
    CrsTaxReportingRecordDto create(CrsTaxReportingRecordDto dto);
    CrsTaxReportingRecordDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CrsTaxReportingRecordDto> listAll();
}
