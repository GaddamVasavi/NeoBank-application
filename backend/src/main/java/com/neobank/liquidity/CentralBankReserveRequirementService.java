package com.neobank.liquidity;
import java.util.List; import java.util.UUID;
public interface CentralBankReserveRequirementService {
    List<CentralBankReserveRequirementDto> getByUser(UUID userId);
    CentralBankReserveRequirementDto create(CentralBankReserveRequirementDto dto);
    CentralBankReserveRequirementDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<CentralBankReserveRequirementDto> listAll();
}
