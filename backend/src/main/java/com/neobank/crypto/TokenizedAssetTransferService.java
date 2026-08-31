package com.neobank.crypto;
import java.util.List; import java.util.UUID;
public interface TokenizedAssetTransferService {
    List<TokenizedAssetTransferDto> getByUser(UUID userId);
    TokenizedAssetTransferDto create(TokenizedAssetTransferDto dto);
    TokenizedAssetTransferDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TokenizedAssetTransferDto> listAll();
}
