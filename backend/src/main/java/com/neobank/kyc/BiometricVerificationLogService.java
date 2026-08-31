package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface BiometricVerificationLogService {
    List<BiometricVerificationLogDto> getByUser(UUID userId);
    BiometricVerificationLogDto create(BiometricVerificationLogDto dto);
    BiometricVerificationLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
