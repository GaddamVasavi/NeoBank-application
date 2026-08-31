package com.neobank.derivatives;
import java.util.List; import java.util.UUID;
public interface SwaptionVolatilitySurfaceLogService {
    List<SwaptionVolatilitySurfaceLogDto> getByUser(UUID userId);
    SwaptionVolatilitySurfaceLogDto create(SwaptionVolatilitySurfaceLogDto dto);
    SwaptionVolatilitySurfaceLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SwaptionVolatilitySurfaceLogDto> listAll();
}
