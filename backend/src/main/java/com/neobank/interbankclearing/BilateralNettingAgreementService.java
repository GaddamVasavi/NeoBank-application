package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface BilateralNettingAgreementService {
    List<BilateralNettingAgreementDto> getByUser(UUID userId);
    BilateralNettingAgreementDto create(BilateralNettingAgreementDto dto);
    BilateralNettingAgreementDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<BilateralNettingAgreementDto> listAll();
}
