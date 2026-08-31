package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface PepScreeningResultService {
    List<PepScreeningResultDto> getByUser(UUID userId);
    PepScreeningResultDto create(PepScreeningResultDto dto);
    PepScreeningResultDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<PepScreeningResultDto> listAll();
}
