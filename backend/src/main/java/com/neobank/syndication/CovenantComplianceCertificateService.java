package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface CovenantComplianceCertificateService {
    List<CovenantComplianceCertificateDto> getByUser(UUID userId);
    CovenantComplianceCertificateDto create(CovenantComplianceCertificateDto dto);
    CovenantComplianceCertificateDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CovenantComplianceCertificateDto> listAll();
}
