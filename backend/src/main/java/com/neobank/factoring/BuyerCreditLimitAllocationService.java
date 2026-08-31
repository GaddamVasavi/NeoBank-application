package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface BuyerCreditLimitAllocationService {
    List<BuyerCreditLimitAllocationDto> getByUser(UUID userId);
    BuyerCreditLimitAllocationDto create(BuyerCreditLimitAllocationDto dto);
    BuyerCreditLimitAllocationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BuyerCreditLimitAllocationDto> listAll();
}
