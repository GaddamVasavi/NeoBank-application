package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface EndOfDaySettlementJobLogService {
    List<EndOfDaySettlementJobLogDto> getByUser(UUID userId);
    EndOfDaySettlementJobLogDto create(EndOfDaySettlementJobLogDto dto);
    EndOfDaySettlementJobLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<EndOfDaySettlementJobLogDto> listAll();
}
