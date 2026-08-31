package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanGuarantorAgreementService {
    List<LoanGuarantorAgreementDto> getByUser(UUID userId);
    LoanGuarantorAgreementDto create(LoanGuarantorAgreementDto dto);
    LoanGuarantorAgreementDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanGuarantorAgreementDto> listAll();
}
