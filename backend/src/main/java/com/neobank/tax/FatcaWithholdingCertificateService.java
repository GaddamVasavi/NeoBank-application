package com.neobank.tax;
import java.util.List; import java.util.UUID;
public interface FatcaWithholdingCertificateService {
    List<FatcaWithholdingCertificateDto> getByUser(UUID userId);
    FatcaWithholdingCertificateDto create(FatcaWithholdingCertificateDto dto);
    FatcaWithholdingCertificateDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FatcaWithholdingCertificateDto> listAll();
}
