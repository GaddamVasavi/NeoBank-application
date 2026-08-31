package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface OpenBankingSecurityCertificateService {
    List<OpenBankingSecurityCertificateDto> getByUser(UUID userId);
    OpenBankingSecurityCertificateDto create(OpenBankingSecurityCertificateDto dto);
    OpenBankingSecurityCertificateDto getByCode(String code);
    void updateState(UUID id, String state);
    List<OpenBankingSecurityCertificateDto> listAll();
}
