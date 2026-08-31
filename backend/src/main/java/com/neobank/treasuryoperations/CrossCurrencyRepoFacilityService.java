package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface CrossCurrencyRepoFacilityService {
    List<CrossCurrencyRepoFacilityDto> getByUser(UUID userId);
    CrossCurrencyRepoFacilityDto create(CrossCurrencyRepoFacilityDto dto);
    CrossCurrencyRepoFacilityDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<CrossCurrencyRepoFacilityDto> listAll();
}
