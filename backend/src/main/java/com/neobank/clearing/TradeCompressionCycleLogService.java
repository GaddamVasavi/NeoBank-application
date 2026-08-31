package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface TradeCompressionCycleLogService {
    List<TradeCompressionCycleLogDto> getByUser(UUID userId);
    TradeCompressionCycleLogDto create(TradeCompressionCycleLogDto dto);
    TradeCompressionCycleLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TradeCompressionCycleLogDto> listAll();
}
