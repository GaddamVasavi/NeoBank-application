package com.neobank.derivatives;
import java.util.List; import java.util.UUID;
public interface TotalReturnSwapDealAgreementService {
    List<TotalReturnSwapDealAgreementDto> getByUser(UUID userId);
    TotalReturnSwapDealAgreementDto create(TotalReturnSwapDealAgreementDto dto);
    TotalReturnSwapDealAgreementDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<TotalReturnSwapDealAgreementDto> listAll();
}
