package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface CentralBankStandingFacilityService {
    List<CentralBankStandingFacilityDto> getByUser(UUID userId);
    CentralBankStandingFacilityDto create(CentralBankStandingFacilityDto dto);
    CentralBankStandingFacilityDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CentralBankStandingFacilityDto> listAll();
}
