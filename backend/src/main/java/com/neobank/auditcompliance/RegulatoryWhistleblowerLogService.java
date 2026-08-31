package com.neobank.auditcompliance;
import java.util.List; import java.util.UUID;
public interface RegulatoryWhistleblowerLogService {
    List<RegulatoryWhistleblowerLogDto> getByUser(UUID userId);
    RegulatoryWhistleblowerLogDto create(RegulatoryWhistleblowerLogDto dto);
    RegulatoryWhistleblowerLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RegulatoryWhistleblowerLogDto> listAll();
}
