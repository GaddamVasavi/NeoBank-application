package com.neobank.identity;
import java.util.List; import java.util.UUID;
public interface BiometricAuthTokenRecordService {
    List<BiometricAuthTokenRecordDto> getByUser(UUID userId);
    BiometricAuthTokenRecordDto create(BiometricAuthTokenRecordDto dto);
    BiometricAuthTokenRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BiometricAuthTokenRecordDto> listAll();
}
