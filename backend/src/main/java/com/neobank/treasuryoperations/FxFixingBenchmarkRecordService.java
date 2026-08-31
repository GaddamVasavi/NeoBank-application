package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface FxFixingBenchmarkRecordService {
    List<FxFixingBenchmarkRecordDto> getByUser(UUID userId);
    FxFixingBenchmarkRecordDto create(FxFixingBenchmarkRecordDto dto);
    FxFixingBenchmarkRecordDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<FxFixingBenchmarkRecordDto> listAll();
}
