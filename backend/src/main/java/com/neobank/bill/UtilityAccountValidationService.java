package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface UtilityAccountValidationService {
    List<UtilityAccountValidationDto> getByUser(UUID userId);
    UtilityAccountValidationDto create(UtilityAccountValidationDto dto);
    UtilityAccountValidationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<UtilityAccountValidationDto> listAll();
}
