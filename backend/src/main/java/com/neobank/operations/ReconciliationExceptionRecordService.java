package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface ReconciliationExceptionRecordService {
    List<ReconciliationExceptionRecordDto> getByUser(UUID userId);
    ReconciliationExceptionRecordDto create(ReconciliationExceptionRecordDto dto);
    ReconciliationExceptionRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ReconciliationExceptionRecordDto> listAll();
}
