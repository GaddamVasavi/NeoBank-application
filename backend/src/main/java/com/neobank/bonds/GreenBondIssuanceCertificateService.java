package com.neobank.bonds;
import java.util.List; import java.util.UUID;
public interface GreenBondIssuanceCertificateService {
    List<GreenBondIssuanceCertificateDto> getByUser(UUID userId);
    GreenBondIssuanceCertificateDto create(GreenBondIssuanceCertificateDto dto);
    GreenBondIssuanceCertificateDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<GreenBondIssuanceCertificateDto> listAll();
}
