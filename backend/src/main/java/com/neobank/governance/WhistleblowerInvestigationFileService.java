package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface WhistleblowerInvestigationFileService {
    List<WhistleblowerInvestigationFileDto> getByUser(UUID userId);
    WhistleblowerInvestigationFileDto create(WhistleblowerInvestigationFileDto dto);
    WhistleblowerInvestigationFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<WhistleblowerInvestigationFileDto> listAll();
}
