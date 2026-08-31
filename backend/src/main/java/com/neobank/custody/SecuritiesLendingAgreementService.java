package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface SecuritiesLendingAgreementService {
    List<SecuritiesLendingAgreementDto> getByUser(UUID userId);
    SecuritiesLendingAgreementDto create(SecuritiesLendingAgreementDto dto);
    SecuritiesLendingAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SecuritiesLendingAgreementDto> listAll();
}
