package com.neobank.fxrates;
import java.util.List; import java.util.UUID;
public interface RealTimeFxRateStreamLogService {
    List<RealTimeFxRateStreamLogDto> getByUser(UUID userId);
    RealTimeFxRateStreamLogDto create(RealTimeFxRateStreamLogDto dto);
    RealTimeFxRateStreamLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RealTimeFxRateStreamLogDto> listAll();
}
