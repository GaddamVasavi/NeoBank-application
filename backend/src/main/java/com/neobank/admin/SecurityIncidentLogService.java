package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface SecurityIncidentLogService {
    List<SecurityIncidentLogDto> getByUser(UUID userId);
    SecurityIncidentLogDto create(SecurityIncidentLogDto dto);
    SecurityIncidentLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SecurityIncidentLogDto> listAll();
}
