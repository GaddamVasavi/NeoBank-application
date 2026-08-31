package com.neobank.regulatory;
import java.util.List; import java.util.UUID;
public interface LargeExposureReturnService {
    List<LargeExposureReturnDto> getByUser(UUID userId);
    LargeExposureReturnDto create(LargeExposureReturnDto dto);
    LargeExposureReturnDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LargeExposureReturnDto> listAll();
}
