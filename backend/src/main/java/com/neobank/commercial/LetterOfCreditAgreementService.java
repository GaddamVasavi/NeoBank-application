package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface LetterOfCreditAgreementService {
    List<LetterOfCreditAgreementDto> getByUser(UUID userId);
    LetterOfCreditAgreementDto create(LetterOfCreditAgreementDto dto);
    LetterOfCreditAgreementDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<LetterOfCreditAgreementDto> listAll();
}
