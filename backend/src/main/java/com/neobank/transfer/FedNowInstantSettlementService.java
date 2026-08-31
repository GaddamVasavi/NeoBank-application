package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface FedNowInstantSettlementService {
    List<FedNowInstantSettlementDto> getByAccount(UUID accountId);
    FedNowInstantSettlementDto create(FedNowInstantSettlementDto dto);
    FedNowInstantSettlementDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
