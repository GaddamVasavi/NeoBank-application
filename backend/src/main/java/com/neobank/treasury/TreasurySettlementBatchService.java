package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface TreasurySettlementBatchService {
    List<TreasurySettlementBatchDto> getByUser(UUID userId);
    TreasurySettlementBatchDto create(TreasurySettlementBatchDto dto);
    TreasurySettlementBatchDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<TreasurySettlementBatchDto> listAll();
}
