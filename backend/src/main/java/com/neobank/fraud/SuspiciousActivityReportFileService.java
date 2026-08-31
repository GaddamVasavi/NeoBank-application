package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface SuspiciousActivityReportFileService {
    List<SuspiciousActivityReportFileDto> getByUser(UUID userId);
    SuspiciousActivityReportFileDto create(SuspiciousActivityReportFileDto dto);
    SuspiciousActivityReportFileDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SuspiciousActivityReportFileDto> listAll();
}
