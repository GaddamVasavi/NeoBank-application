package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface NetInterestMarginReportService {
    List<NetInterestMarginReportDto> getByUser(UUID userId);
    NetInterestMarginReportDto create(NetInterestMarginReportDto dto);
    NetInterestMarginReportDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<NetInterestMarginReportDto> listAll();
}
