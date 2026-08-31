package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface HardwareKeyEnrollmentLogService {
    List<HardwareKeyEnrollmentLogDto> getByUser(UUID userId);
    HardwareKeyEnrollmentLogDto create(HardwareKeyEnrollmentLogDto dto);
    HardwareKeyEnrollmentLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<HardwareKeyEnrollmentLogDto> listAll();
}
