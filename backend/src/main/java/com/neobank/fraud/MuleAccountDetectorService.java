package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface MuleAccountDetectorService {
    List<MuleAccountDetectorDto> getByUser(UUID userId);
    MuleAccountDetectorDto create(MuleAccountDetectorDto dto);
    MuleAccountDetectorDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<MuleAccountDetectorDto> listAll();
}
