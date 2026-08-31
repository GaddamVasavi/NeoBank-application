package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface SyndicatedLoanFacilityService {
    List<SyndicatedLoanFacilityDto> getByUser(UUID userId);
    SyndicatedLoanFacilityDto create(SyndicatedLoanFacilityDto dto);
    SyndicatedLoanFacilityDto getByCode(String code);
    void updateState(UUID id, String state);
    List<SyndicatedLoanFacilityDto> listAll();
}
