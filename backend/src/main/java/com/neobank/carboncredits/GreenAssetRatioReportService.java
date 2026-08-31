package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface GreenAssetRatioReportService {
    List<GreenAssetRatioReportDto> getByUser(UUID userId);
    GreenAssetRatioReportDto create(GreenAssetRatioReportDto dto);
    GreenAssetRatioReportDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<GreenAssetRatioReportDto> listAll();
}
