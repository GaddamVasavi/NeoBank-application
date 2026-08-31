package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface ExportFactoringAgreementService {
    List<ExportFactoringAgreementDto> getByUser(UUID userId);
    ExportFactoringAgreementDto create(ExportFactoringAgreementDto dto);
    ExportFactoringAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ExportFactoringAgreementDto> listAll();
}
