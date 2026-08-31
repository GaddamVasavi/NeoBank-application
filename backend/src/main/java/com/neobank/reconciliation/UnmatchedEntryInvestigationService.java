package com.neobank.reconciliation;
import java.util.List; import java.util.UUID;
public interface UnmatchedEntryInvestigationService {
    List<UnmatchedEntryInvestigationDto> getByUser(UUID userId);
    UnmatchedEntryInvestigationDto create(UnmatchedEntryInvestigationDto dto);
    UnmatchedEntryInvestigationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<UnmatchedEntryInvestigationDto> listAll();
}
