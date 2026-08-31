package com.neobank.crypto;
import java.util.List; import java.util.UUID;
public interface CrossChainBridgeSwapService {
    List<CrossChainBridgeSwapDto> getByUser(UUID userId);
    CrossChainBridgeSwapDto create(CrossChainBridgeSwapDto dto);
    CrossChainBridgeSwapDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CrossChainBridgeSwapDto> listAll();
}
