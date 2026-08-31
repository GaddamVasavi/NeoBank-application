package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface BatchSettlementJobService {
    List<BatchSettlementJobDto> getByUser(UUID userId);
    BatchSettlementJobDto create(BatchSettlementJobDto dto);
    BatchSettlementJobDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BatchSettlementJobDto> listAll();
}
