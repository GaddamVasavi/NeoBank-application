package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface ClaimsInvestigationFileService {
    List<ClaimsInvestigationFileDto> getByUser(UUID userId);
    ClaimsInvestigationFileDto create(ClaimsInvestigationFileDto dto);
    ClaimsInvestigationFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ClaimsInvestigationFileDto> listAll();
}
