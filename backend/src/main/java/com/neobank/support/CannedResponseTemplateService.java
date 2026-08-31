package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface CannedResponseTemplateService {
    List<CannedResponseTemplateDto> getByUser(UUID userId);
    CannedResponseTemplateDto create(CannedResponseTemplateDto dto);
    CannedResponseTemplateDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CannedResponseTemplateDto> listAll();
}
