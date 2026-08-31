package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface AdminAccessLogService {
    List<AdminAccessLogDto> getByUser(UUID userId);
    AdminAccessLogDto create(AdminAccessLogDto dto);
    AdminAccessLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AdminAccessLogDto> listAll();
}
