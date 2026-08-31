package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface WhistleblowerCaseFileService {
    List<WhistleblowerCaseFileDto> getByUser(UUID userId);
    WhistleblowerCaseFileDto create(WhistleblowerCaseFileDto dto);
    WhistleblowerCaseFileDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<WhistleblowerCaseFileDto> listAll();
}
