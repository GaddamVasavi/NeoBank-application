package com.neobank.merchant;
import java.util.List; import java.util.UUID;
public interface InterchangeFeeScheduleLogService {
    List<InterchangeFeeScheduleLogDto> getByUser(UUID userId);
    InterchangeFeeScheduleLogDto create(InterchangeFeeScheduleLogDto dto);
    InterchangeFeeScheduleLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InterchangeFeeScheduleLogDto> listAll();
}
