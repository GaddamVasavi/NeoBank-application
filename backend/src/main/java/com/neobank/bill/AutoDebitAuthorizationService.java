package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface AutoDebitAuthorizationService {
    List<AutoDebitAuthorizationDto> getByUser(UUID userId);
    AutoDebitAuthorizationDto create(AutoDebitAuthorizationDto dto);
    AutoDebitAuthorizationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AutoDebitAuthorizationDto> listAll();
}
