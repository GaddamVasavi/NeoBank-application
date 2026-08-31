package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface FatcaDeclarationCertificateService {
    List<FatcaDeclarationCertificateDto> getByUser(UUID userId);
    FatcaDeclarationCertificateDto create(FatcaDeclarationCertificateDto dto);
    FatcaDeclarationCertificateDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<FatcaDeclarationCertificateDto> listAll();
}
