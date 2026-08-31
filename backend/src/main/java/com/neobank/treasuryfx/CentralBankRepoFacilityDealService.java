package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface CentralBankRepoFacilityDealService {
    List<CentralBankRepoFacilityDealDto> getByUser(UUID userId);
    CentralBankRepoFacilityDealDto create(CentralBankRepoFacilityDealDto dto);
    CentralBankRepoFacilityDealDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CentralBankRepoFacilityDealDto> listAll();
}
