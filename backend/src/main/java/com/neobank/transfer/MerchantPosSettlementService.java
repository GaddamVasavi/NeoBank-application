package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface MerchantPosSettlementService {
    List<MerchantPosSettlementDto> getByAccount(UUID accountId);
    MerchantPosSettlementDto create(MerchantPosSettlementDto dto);
    MerchantPosSettlementDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
