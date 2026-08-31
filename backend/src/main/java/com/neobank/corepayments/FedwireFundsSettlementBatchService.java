package com.neobank.corepayments;
import java.util.List; import java.util.UUID;
public interface FedwireFundsSettlementBatchService {
    List<FedwireFundsSettlementBatchDto> getByUser(UUID userId);
    FedwireFundsSettlementBatchDto create(FedwireFundsSettlementBatchDto dto);
    FedwireFundsSettlementBatchDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<FedwireFundsSettlementBatchDto> listAll();
}
