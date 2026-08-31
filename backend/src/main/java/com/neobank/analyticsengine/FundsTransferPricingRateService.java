package com.neobank.analyticsengine;
import java.util.List; import java.util.UUID;
public interface FundsTransferPricingRateService {
    List<FundsTransferPricingRateDto> getByUser(UUID userId);
    FundsTransferPricingRateDto create(FundsTransferPricingRateDto dto);
    FundsTransferPricingRateDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FundsTransferPricingRateDto> listAll();
}
