package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface SupportCallbackRequestService {
    List<SupportCallbackRequestDto> getByUser(UUID userId);
    SupportCallbackRequestDto create(SupportCallbackRequestDto dto);
    SupportCallbackRequestDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SupportCallbackRequestDto> listAll();
}
