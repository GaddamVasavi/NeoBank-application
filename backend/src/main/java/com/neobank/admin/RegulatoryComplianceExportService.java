package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface RegulatoryComplianceExportService {
    List<RegulatoryComplianceExportDto> getByUser(UUID userId);
    RegulatoryComplianceExportDto create(RegulatoryComplianceExportDto dto);
    RegulatoryComplianceExportDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RegulatoryComplianceExportDto> listAll();
}
