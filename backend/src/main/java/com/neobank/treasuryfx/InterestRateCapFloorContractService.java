package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface InterestRateCapFloorContractService {
    List<InterestRateCapFloorContractDto> getByUser(UUID userId);
    InterestRateCapFloorContractDto create(InterestRateCapFloorContractDto dto);
    InterestRateCapFloorContractDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InterestRateCapFloorContractDto> listAll();
}
