package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface IdentityVerificationLogService {
    List<IdentityVerificationLogDto> getByUser(UUID userId);
    IdentityVerificationLogDto create(IdentityVerificationLogDto dto);
    IdentityVerificationLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<IdentityVerificationLogDto> listAll();
}
