package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface InterbankClearingSettlementBatchService {
    List<InterbankClearingSettlementBatchDto> getByUser(UUID userId);
    InterbankClearingSettlementBatchDto create(InterbankClearingSettlementBatchDto dto);
    InterbankClearingSettlementBatchDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<InterbankClearingSettlementBatchDto> listAll();
}
