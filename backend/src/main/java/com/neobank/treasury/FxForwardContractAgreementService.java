package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface FxForwardContractAgreementService {
    List<FxForwardContractAgreementDto> getByUser(UUID userId);
    FxForwardContractAgreementDto create(FxForwardContractAgreementDto dto);
    FxForwardContractAgreementDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<FxForwardContractAgreementDto> listAll();
}
