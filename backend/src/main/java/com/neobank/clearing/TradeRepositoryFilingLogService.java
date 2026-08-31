package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface TradeRepositoryFilingLogService {
    List<TradeRepositoryFilingLogDto> getByUser(UUID userId);
    TradeRepositoryFilingLogDto create(TradeRepositoryFilingLogDto dto);
    TradeRepositoryFilingLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TradeRepositoryFilingLogDto> listAll();
}
