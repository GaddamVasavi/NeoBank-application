package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface CarbonCreditRegistryEntryService {
    List<CarbonCreditRegistryEntryDto> getByUser(UUID userId);
    CarbonCreditRegistryEntryDto create(CarbonCreditRegistryEntryDto dto);
    CarbonCreditRegistryEntryDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CarbonCreditRegistryEntryDto> listAll();
}
