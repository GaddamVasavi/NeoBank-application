package com.neobank.reconciliation;
import java.util.List; import java.util.UUID;
public interface DailyGlReconciliationRecordService {
    List<DailyGlReconciliationRecordDto> getByUser(UUID userId);
    DailyGlReconciliationRecordDto create(DailyGlReconciliationRecordDto dto);
    DailyGlReconciliationRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DailyGlReconciliationRecordDto> listAll();
}
