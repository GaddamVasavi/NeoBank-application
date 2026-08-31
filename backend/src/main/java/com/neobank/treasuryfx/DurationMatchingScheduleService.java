package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface DurationMatchingScheduleService {
    List<DurationMatchingScheduleDto> getByUser(UUID userId);
    DurationMatchingScheduleDto create(DurationMatchingScheduleDto dto);
    DurationMatchingScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DurationMatchingScheduleDto> listAll();
}
