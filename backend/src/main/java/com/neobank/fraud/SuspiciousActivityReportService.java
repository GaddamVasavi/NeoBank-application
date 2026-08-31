package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface SuspiciousActivityReportService {
    List<SuspiciousActivityReportDto> getByUser(UUID userId);
    SuspiciousActivityReportDto create(SuspiciousActivityReportDto dto);
    SuspiciousActivityReportDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
