package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface AnnualGeneralMeetingDossierService {
    List<AnnualGeneralMeetingDossierDto> getByUser(UUID userId);
    AnnualGeneralMeetingDossierDto create(AnnualGeneralMeetingDossierDto dto);
    AnnualGeneralMeetingDossierDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AnnualGeneralMeetingDossierDto> listAll();
}
