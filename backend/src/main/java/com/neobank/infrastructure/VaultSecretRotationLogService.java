package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface VaultSecretRotationLogService {
    List<VaultSecretRotationLogDto> getByUser(UUID userId);
    VaultSecretRotationLogDto create(VaultSecretRotationLogDto dto);
    VaultSecretRotationLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<VaultSecretRotationLogDto> listAll();
}
