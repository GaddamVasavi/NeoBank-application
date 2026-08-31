package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface InterestRateSwapContractService {
    List<InterestRateSwapContractDto> getByUser(UUID userId);
    InterestRateSwapContractDto create(InterestRateSwapContractDto dto);
    InterestRateSwapContractDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<InterestRateSwapContractDto> listAll();
}
