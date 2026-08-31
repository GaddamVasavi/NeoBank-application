package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface LiquidityLadderReportService {
    List<LiquidityLadderReportDto> getByUser(UUID userId);
    LiquidityLadderReportDto create(LiquidityLadderReportDto dto);
    LiquidityLadderReportDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<LiquidityLadderReportDto> listAll();
}
