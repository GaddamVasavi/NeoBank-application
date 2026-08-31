package com.neobank.auditcompliance;
import java.util.List; import java.util.UUID;
public interface BaselCapitalBufferRatioLogService {
    List<BaselCapitalBufferRatioLogDto> getByUser(UUID userId);
    BaselCapitalBufferRatioLogDto create(BaselCapitalBufferRatioLogDto dto);
    BaselCapitalBufferRatioLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BaselCapitalBufferRatioLogDto> listAll();
}
