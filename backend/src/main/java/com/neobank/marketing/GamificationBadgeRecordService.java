package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface GamificationBadgeRecordService {
    List<GamificationBadgeRecordDto> getByUser(UUID userId);
    GamificationBadgeRecordDto create(GamificationBadgeRecordDto dto);
    GamificationBadgeRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<GamificationBadgeRecordDto> listAll();
}
