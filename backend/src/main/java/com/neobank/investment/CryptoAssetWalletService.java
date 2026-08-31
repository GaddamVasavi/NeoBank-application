package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface CryptoAssetWalletService {
    List<CryptoAssetWalletDto> getByUser(UUID userId);
    CryptoAssetWalletDto create(CryptoAssetWalletDto dto);
    CryptoAssetWalletDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CryptoAssetWalletDto> listAll();
}
