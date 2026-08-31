package com.neobank.crypto;
import java.util.List; import java.util.UUID;
public interface BlockchainGasFeeEstimateService {
    List<BlockchainGasFeeEstimateDto> getByUser(UUID userId);
    BlockchainGasFeeEstimateDto create(BlockchainGasFeeEstimateDto dto);
    BlockchainGasFeeEstimateDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BlockchainGasFeeEstimateDto> listAll();
}
