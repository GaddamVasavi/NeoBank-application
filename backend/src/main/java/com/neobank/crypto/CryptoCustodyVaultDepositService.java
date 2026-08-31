package com.neobank.crypto;
import java.util.List; import java.util.UUID;
public interface CryptoCustodyVaultDepositService {
    List<CryptoCustodyVaultDepositDto> getByUser(UUID userId);
    CryptoCustodyVaultDepositDto create(CryptoCustodyVaultDepositDto dto);
    CryptoCustodyVaultDepositDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CryptoCustodyVaultDepositDto> listAll();
}
