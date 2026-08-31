package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface CurrencyHedgingContractService {
    List<CurrencyHedgingContractDto> getByAccount(UUID accountId);
    CurrencyHedgingContractDto create(CurrencyHedgingContractDto dto);
    CurrencyHedgingContractDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
