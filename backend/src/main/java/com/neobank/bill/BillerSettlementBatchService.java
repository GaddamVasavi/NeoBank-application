package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface BillerSettlementBatchService {
    List<BillerSettlementBatchDto> getByUser(UUID userId);
    BillerSettlementBatchDto create(BillerSettlementBatchDto dto);
    BillerSettlementBatchDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BillerSettlementBatchDto> listAll();
}
