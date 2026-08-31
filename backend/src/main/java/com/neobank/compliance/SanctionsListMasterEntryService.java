package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface SanctionsListMasterEntryService {
    List<SanctionsListMasterEntryDto> getByUser(UUID userId);
    SanctionsListMasterEntryDto create(SanctionsListMasterEntryDto dto);
    SanctionsListMasterEntryDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<SanctionsListMasterEntryDto> listAll();
}
