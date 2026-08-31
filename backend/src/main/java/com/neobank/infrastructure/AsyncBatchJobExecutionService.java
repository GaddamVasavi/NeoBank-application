package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface AsyncBatchJobExecutionService {
    List<AsyncBatchJobExecutionDto> getByUser(UUID userId);
    AsyncBatchJobExecutionDto create(AsyncBatchJobExecutionDto dto);
    AsyncBatchJobExecutionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AsyncBatchJobExecutionDto> listAll();
}
