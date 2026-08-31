package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface CashInTransitRecordService {
    List<CashInTransitRecordDto> getByUser(UUID userId);
    CashInTransitRecordDto create(CashInTransitRecordDto dto);
    CashInTransitRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CashInTransitRecordDto> listAll();
}
