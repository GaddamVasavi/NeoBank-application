package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface PensionAnnuityDisbursementService {
    List<PensionAnnuityDisbursementDto> getByUser(UUID userId);
    PensionAnnuityDisbursementDto create(PensionAnnuityDisbursementDto dto);
    PensionAnnuityDisbursementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PensionAnnuityDisbursementDto> listAll();
}
