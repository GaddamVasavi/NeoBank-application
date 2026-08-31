package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface ForwardRateAgreementDealService {
    List<ForwardRateAgreementDealDto> getByUser(UUID userId);
    ForwardRateAgreementDealDto create(ForwardRateAgreementDealDto dto);
    ForwardRateAgreementDealDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ForwardRateAgreementDealDto> listAll();
}
